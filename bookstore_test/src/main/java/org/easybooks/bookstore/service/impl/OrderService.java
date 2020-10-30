package org.easybooks.bookstore.service.impl;

import org.easybooks.bookstore.dao.IOrderDAO;
import org.easybooks.bookstore.service.IOrderService;
import org.easybooks.bookstore.vo.Order;
public class OrderService implements IOrderService{
	private IOrderDAO orderDAO;
	public void setOrderDAO(IOrderDAO orderDAO){
		this.orderDAO=orderDAO;
	}
	//���湺����Ϣ(���涩��)
	public Order saveOrder(Order order) {
		return orderDAO.saveOrder(order);
	}
}