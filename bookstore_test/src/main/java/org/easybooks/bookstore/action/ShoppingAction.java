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
	
	//��ӵ����ﳵ
	public String addToCart() throws Exception{
		Book book=bookService.getBookbyId(bookid);
		//����Orderitem���� ��������:Book��quantity
		OrderItem orderitem=new OrderItem();
		orderitem.setBook(book);
		orderitem.setQuantity(quantity);
		Map session=ActionContext.getContext().getSession();
		Cart cart=(Cart)session.get("cart");
		//�жϹ��ﳵ�Ƿ���ڣ���������ڣ��򴴽�һ�����ﳵ��
		//������ڣ����ͼ�鵽���ﳵ
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
	//�����¶���
	public String checkout()throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Cart cart=(Cart)session.get("cart");
		if(user==null||cart==null)
			return ActionSupport.ERROR;
		//׼����������order
		Order order=new Order();
		order.setOrderDate(new Date());
		order.setUser(user);
		//�������ﳵ�е�ͼ�飬���ɶ�����Ŀ����һ����֯�ɶ���
		for(Iterator it=cart.getItems().values().iterator();it.hasNext();){
			//�õ����ﳵ�е�����orderitem���������е�����Ԫ����䵽������������
			OrderItem orderitem=(OrderItem)it.next();
			orderitem.setOrder(order);
			order.getOrderItems();
		}
		orderService.saveOrder(order);//���涩��
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("order",order);
		session.remove("cart");//������ﳵ
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
