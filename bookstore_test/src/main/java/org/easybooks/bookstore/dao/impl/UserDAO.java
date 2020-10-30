package org.easybooks.bookstore.dao.impl;

import java.util.List;

import org.easybooks.bookstore.dao.BaseDAO;
import org.easybooks.bookstore.dao.IUserDAO;
import org.easybooks.bookstore.vo.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDAO extends BaseDAO implements IUserDAO {

	public void saveUser(User user) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}

	public User validateUser(String username, String password) {
		Session session = getSession();
		String hql = "from User u where u.userName=?0 and u.passWord=?1";
		Query<User> query = session.createQuery(hql, User.class).setParameter(0, username).setParameter(1, password)
				.setMaxResults(1);
		List<User> users = query.getResultList();
		if (users.size() != 0) {
			User u = (User) users.get(0);
			return u;
		}
		session.close();
		return null;
	}

	@Override
	public boolean exitUser(String username) {
		Session session = getSession();
		String hql = "from User u where u.username=?0";
		Query<?> query = session.createQuery(hql);
		query.setParameter(0, username);
		List<?> users = query.list();
		session.close();
		if (users.size() != 0) {
//			User user=(User)users.get(0);
			return true;
		}
		return false;
	}

}
