package org.easybooks.bookstore.action;

import java.util.Date;
import java.util.Map;
import java.util.Iterator;

import org.easybooks.bookstore.model.Cart;
import org.easybooks.bookstore.service.*;
import org.easybooks.bookstore.vo.*;
import com.opensymphony.xwork2.*;

public class ShoppingAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int quantity;
	private Integer bookId;
	private IBookService bookService;
	private IOrderService orderService;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public IBookService getBookService() {
		return bookService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	public String addToCart() throws Exception {
		Book book = bookService.getBookbyId(bookId);
		OrderItem orderitem = new OrderItem();
		orderitem.setBook(book);
		orderitem.setQuantity(quantity);
		Map<String, Object> session = ActionContext.getContext().getSession();
		Cart cart = (Cart) session.get("cart");
		if (cart == null) {
			cart = new Cart();
		}
		cart.addBook(bookId, orderitem);
		session.put("cart", cart);
		return SUCCESS;
	}

	public String updateCart() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Cart cart = (Cart) session.get("cart");
		cart.updateCart(bookId, quantity);
		session.put("cart", cart);
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String checkout() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		Cart cart = (Cart) session.get("cart");
		if (user == null || cart == null)
			return ActionSupport.ERROR;
		Order order = new Order();
		order.setOrderDate(new Date());
		order.setUser(user);
		for (Iterator<?> it = cart.getItems().values().iterator(); it.hasNext();) {
			OrderItem orderitem = (OrderItem) it.next();
			orderitem.setOrder(order);
			order.getOrderItems();
		}
		orderService.saveOrder(order);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("order", order);
		session.remove("cart");
		return SUCCESS;
	}

	public String deleteBook() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Cart cart = (Cart) session.get("cart");
		cart.getItems().remove(bookId);
		session.put("cart", cart);
		return SUCCESS;
	}

}
