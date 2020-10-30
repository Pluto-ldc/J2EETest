package org.easybooks.bookstore.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class BaseDAO {
	private SessionFactory sessionFactory;  //类的属性，它是一个引用

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	//为设值注入作准备
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//获取会话
	public Session getSession()
	{
		Session session=sessionFactory.openSession();
		return session;
		
	}
}