package org.easybooks.bookstore.dao.impl;

import java.util.List;

import org.easybooks.bookstore.dao.IUserDAO;
import org.easybooks.bookstore.vo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UserDAO implements IUserDAO {

	@Override
	public User validate(User user) {
		// TODO Auto-generated method stub
		String sql = "from User u where u.userName = ?0 and u.passWord = ?1";
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query<User> query = session.createQuery(sql,User.class)
				.setParameter(0, user.getUserName())
				.setParameter(1, user.getPassWord())
				.setMaxResults(1);
		List<User> users=query.getResultList();
		User exsitUser;
		if (users.size() != 0) {
			exsitUser = users.get(0);
		} else {
			exsitUser = null;
		}
		session.close();
		sessionFactory.close();
		return exsitUser;
	}

}
