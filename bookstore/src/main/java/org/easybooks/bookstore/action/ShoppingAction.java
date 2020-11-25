package org.easybooks.bookstore.action;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.easybooks.bookstore.model.Cart;
import org.easybooks.bookstore.service.*;
import org.easybooks.bookstore.vo.Book;
import org.easybooks.bookstore.vo.Order;
import org.easybooks.bookstore.vo.OrderItem;
import org.easybooks.bookstore.vo.User;

import com.opensymphony.xwork2.*;

public class ShoppingAction extends ActionSupport {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final String CART = "cart";
	private static final String ORDER = "order";
	private static final String USER = "user";

	private IBookService bookService;

	private IOrderService orderService;

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 图书Id
	 */
	private Integer bookId;

	/**
	 * 图书的数量
	 */
	private int quantity;

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	/**
	 * 根据图书的Id和数量放入购物车
	 * 
	 * @return
	 */
	public String addToCart() {
		// 根据图书Id获取到图书对象
		Book book = bookService.getBookbyId(bookId);
		// 获得session对象
		Map<String, Object> session = ActionContext.getContext().getSession();
		// 从session中根据键“cart”获取到购物车对象
		Cart cart = (Cart) session.get(CART);
		// 或从session中获取不到购物车对象，则初始化对象
		if (cart == null) {
			cart = new Cart();
		}
		// 像购物车中添加图书
		cart.addBook(bookId, new OrderItem(book, quantity));
		// 将修改后的图书对象存入session
		session.put(CART, cart);
		return SUCCESS;
	}

	/**
	 * 修改购物车中图书的数量
	 * 
	 * @return
	 */
	public String updateCart() {
		// 获得session对象
		Map<String, Object> session = ActionContext.getContext().getSession();
		// 从session中根据键“cart”获取到购物车对象
		Cart cart = (Cart) session.get("cart");
		// 将新数据提交到购物车对象去修改
		cart.updateCart(bookId, quantity);
		// 将修改后的图书对象存入session
		session.put(CART, cart);
		return SUCCESS;
	}

	public String deleteBook() {
		// 获得session对象
		Map<String, Object> session = ActionContext.getContext().getSession();
		// 从session中根据键“cart”获取到购物车对象
		Cart cart = (Cart) session.get(CART);
		// 根据图书Id移除图书
		cart.getCartMap().remove(bookId);
		// 将修改后的图书对象存入session
		session.put(CART, cart);
		return SUCCESS;
	}

	public String checkout() {
		// 获得session对象
		Map<String, Object> session = ActionContext.getContext().getSession();
		// 从session中根据键“user”获取到用户对象
		User user = (User) session.get(USER);
		// 从session中根据键“cart”获取到购物车对象
		Cart cart = (Cart) session.get(CART);
		// 若用户对象或者购物车对象为空，则返回错误页面，即用户未登陆或购物车中没有数据
		if (user == null || cart == null) {
			this.message = "请先登陆！";
			return ERROR;
		}
		// 新建order对象
		Order order = new Order();
		// 赋值
		order.setUser(user);
		order.setOrderDate(new Date());
		// 新建Set对象
		Set<OrderItem> orderItems = new HashSet<>();
		// 遍历购物车中的所有图书
		for (Iterator<OrderItem> it = cart.getCartMap().values().iterator(); it.hasNext();) {
			OrderItem orderItem = it.next();
			orderItem.setOrder(order);
			orderItems.add(orderItem);
		}
		order.setOrderItems(orderItems);
		orderService.saveOrder(order);
		ServletActionContext.getRequest().setAttribute(ORDER, order);
		session.remove(CART);
		return SUCCESS;
	}

}
