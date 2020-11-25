package org.easybooks.bookstore.dao.impl;

import org.easybooks.bookstore.dao.BaseDAO;
import org.easybooks.bookstore.dao.IUserDAO;
import org.easybooks.bookstore.vo.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDAO extends BaseDAO implements IUserDAO {

	@Override
	public User validateUser(String userName, String passWord) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.userName = ?0 and u.passWord = ?1";
		Session session = getSession();
		Query<User> query = session.createQuery(hql, User.class).setParameter(0, userName).setParameter(1, passWord)
				.setMaxResults(1);
		User user = query.uniqueResult();
		session.close();
		return user != null ? user : null;
	}

	@Override
	public Integer saveUser(User user) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Integer code = null;
		if (!checkUser(user.getUserName())) {
			Transaction tx = session.beginTransaction();
			code = (Integer) session.save(user);
			tx.commit();
		}
		session.close();
		return code;
	}

	@Override
	public Boolean checkUser(String userName) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "from User u where u.userName = ?0";
		Query<User> query = session.createQuery(hql, User.class).setParameter(0, userName).setMaxResults(1);
		User user = query.uniqueResult();
		session.close();
		return user != null;
	}

}
