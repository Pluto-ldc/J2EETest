package org.easybooks.bookstore.service.impl;

import org.easybooks.bookstore.dao.IUserDAO;
import org.easybooks.bookstore.service.IUserService;
import org.easybooks.bookstore.vo.User;

public class UserService implements IUserService {

	private IUserDAO userDAO;

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User validateUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.validate(user);
	}

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		Integer code = userDAO.saveUser(user);
		return code != null ? userDAO.validate(user) : null;
	}

}
