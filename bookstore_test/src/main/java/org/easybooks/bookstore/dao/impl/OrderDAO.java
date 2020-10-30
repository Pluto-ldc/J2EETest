package org.easybooks.bookstore.dao.impl;

import org.easybooks.bookstore.dao.*;
import org.easybooks.bookstore.vo.Orders;
import org.hibernate.*;

public class OrderDAO extends BaseDAO implements IOrderDAO{

	//保存购物信息(保存订单)
	public Orders saveOrder(Orders order) {
		Session session=getSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		session.save(order);
		tx.commit();//提交事务
		session.close();
		return order;
	}
	
}
