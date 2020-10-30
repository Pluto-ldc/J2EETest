package org.easybooks.bookstore.dao;

import org.easybooks.bookstore.vo.Order;

public interface IOrderDAO {
	public Order saveOrder(Order order);
}
