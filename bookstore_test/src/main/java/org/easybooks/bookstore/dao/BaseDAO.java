package org.easybooks.bookstore.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class BaseDAO {
	private SessionFactory sessionFactory;  //������ԣ�����һ������

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	//Ϊ��ֵע����׼��
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//��ȡ�Ự
	public Session getSession()
	{
		Session session=sessionFactory.openSession();
		return session;
		
	}
}