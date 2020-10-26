package org.easybooks.bookstore.test;

import org.easybooks.bookstore.vo.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

class Test1 {

	@Test
	void test() {
		Configuration configuration = new Configuration();
		SessionFactory sf = configuration.configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		User user = new User("张三", "123456@qq.com");
		session.save(user);
		transaction.commit();
		session.close();
	}

	@Test
	void test2() {
		Configuration configuration = new Configuration();
		System.out.println(configuration);
	}
	@Test
	void testSelect() {
		Configuration configuration=new Configuration();
		SessionFactory sessionFactory=configuration.configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from User u where u.id = 1 ");
		Query<User> query2 =session.createQuery("from User");
		User user=(User) query.uniqueResult();
		java.util.List<User> users=query2.list();
		System.out.println(user.toString());
		for (User user2 : users) {
			System.out.println(user2.toString());
		}
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
