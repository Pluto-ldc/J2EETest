package org.easybooks.bookstore.service;

import org.easybooks.bookstore.vo.Orders;

public interface IOrderService {
	public Orders saveOrder(Orders order);
}
