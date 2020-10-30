package org.easybooks.bookstore.dao.impl;

import org.easybooks.bookstore.dao.*;
import org.easybooks.bookstore.vo.Orders;
import org.hibernate.*;

public class OrderDAO extends BaseDAO implements IOrderDAO{

	//���湺����Ϣ(���涩��)
	public Orders saveOrder(Orders order) {
		Session session=getSession();
		//��������
		Transaction tx=session.beginTransaction();
		session.save(order);
		tx.commit();//�ύ����
		session.close();
		return order;
	}
	
}
