package org.easybooks.bookstore.dao.impl;

import java.util.List;

import org.easybooks.bookstore.dao.BaseDAO;
import org.easybooks.bookstore.dao.IUserDAO;
import org.easybooks.bookstore.vo.User;
import org.hibernate.Query;
import org.hibernate.Session;

public class UserDAO extends BaseDAO implements IUserDAO {

	@Override
	public User validate(User user) {
		// TODO Auto-generated method stub
		String sql = "from User u where u.userName = ?0 and u.passWord = ?1";
		Session session = getSession();
		Query query = session.createQuery(sql);
		query.setParameter(0, user.getUserName());
		query.setParameter(1, user.getPassWord());
		List<User> users = query.list();
		User exsitUser=null;
		if (users.size() != 0) {
			exsitUser = users.get(0);
		}
		session.close();
		return exsitUser;
	}

}
