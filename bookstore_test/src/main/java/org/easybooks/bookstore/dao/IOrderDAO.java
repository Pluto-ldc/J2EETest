package org.easybooks.bookstore.dao;

import org.easybooks.bookstore.vo.Orders;

public interface IOrderDAO {
	public Orders saveOrder(Orders order);
}
