package org.easybooks.bookstore.action;

import java.util.Date;
import java.util.Map;
import java.util.Iterator;

import org.easybooks.bookstore.model.Cart;
import org.easybooks.bookstore.service.*;
import org.easybooks.bookstore.vo.*;
import com.opensymphony.xwork2.*;

public class ShoppingAction extends ActionSupport{
	private int quantity;
	private Integer bookid;
	private IBookService bookService;
	private IOrderService orderService;
	
	//添加到购物车
	public String addToCart() throws Exception{
		Book book=bookService.getBookbyId(bookid);
		//创建Orderitem对象 设置属性:Book，quantity
		Orderitem orderitem=new Orderitem();
		orderitem.setBook(book);
		orderitem.setQuantity(quantity);
		Map session=ActionContext.getContext().getSession();
		Cart cart=(Cart)session.get("cart");
		//判断购物车是否存在，如果不存在，则创建一个购物车。
		//如果存在，添加图书到购物车
		if(cart==null){
			cart=new Cart();
		}
		cart.addBook(bookid, orderitem);
		session.put("cart",cart);
		return SUCCESS;
	}
	
	public String updateCart()throws Exception{
		Map session=ActionContext.getContext().getSession();
		Cart cart=(Cart)session.get("cart");
		cart.updateCart(bookid,quantity);
		session.put("cart", cart);
		return SUCCESS;
	}
	//结账下订单
	public String checkout()throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Cart cart=(Cart)session.get("cart");
		if(user==null||cart==null)
			return ActionSupport.ERROR;
		//准备订单对象order
		Orders order=new Orders();
		order.setOrderdate(new Date());
		order.setUser(user);
		//遍历购物车中的图书，生成订单项目，进一步组织成订单
		for(Iterator it=cart.getItems().values().iterator();it.hasNext();){
			//得到购物车中的所有orderitem，将集合中的所有元素填充到迭代器对象中
			Orderitem orderitem=(Orderitem)it.next();
			orderitem.setOrders(order);
			order.getOrderitems().add(orderitem);
		}
		orderService.saveOrder(order);//保存订单
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("order",order);
		session.remove("cart");//清除购物车
		return SUCCESS;
		}
	
	public String deleteBook()throws Exception{
		Map session=ActionContext.getContext().getSession();
		Cart cart=(Cart)session.get("cart");
		cart.getItems().remove(bookid);
		session.put("cart",cart);
		return SUCCESS;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
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
	
}
