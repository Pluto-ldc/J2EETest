package org.easybooks.bookstore.dao.impl;

import org.easybooks.bookstore.dao.*;
import org.easybooks.bookstore.vo.Order;
import org.hibernate.*;

public class OrderDAO extends BaseDAO implements IOrderDAO{


	@Override
	public Order saveOrder(Order order) {
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.save(order);
		tx.commit();
		session.close();
		return order;
	}
	
}
