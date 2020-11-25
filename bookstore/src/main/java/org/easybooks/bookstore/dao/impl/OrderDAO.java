package org.easybooks.bookstore.dao.impl;

import java.util.Set;

import org.easybooks.bookstore.dao.BaseDAO;
import org.easybooks.bookstore.dao.IOrderDAO;
import org.easybooks.bookstore.vo.Order;
import org.easybooks.bookstore.vo.OrderItem;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDAO extends BaseDAO implements IOrderDAO {

	@Override
	public Order saveOrder(Order order) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		if (session.save(order) == null) {
			order = null;
		}
		Set<OrderItem> orderItems = order.getOrderItems();
		for (OrderItem orderItem : orderItems) {
			session.save(orderItem);
		}
		tx.commit();
		session.close();
		return order;
	}

}
