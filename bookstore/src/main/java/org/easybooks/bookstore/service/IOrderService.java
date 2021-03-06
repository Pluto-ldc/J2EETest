package org.easybooks.bookstore.service;

import org.easybooks.bookstore.vo.Order;

public interface IOrderService {

	/**
	 * 接收订单对象以保存订单
	 * 
	 * @param order 订单对象
	 * @return 返回传入对象，若失败则返回null
	 */
	Order saveOrder(Order order);

}
