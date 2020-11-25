package org.easybooks.bookstore.service.impl;

import org.easybooks.bookstore.dao.IUserDAO;
import org.easybooks.bookstore.service.IUserService;
import org.easybooks.bookstore.vo.User;

public class UserService implements IUserService {

	private IUserDAO userDAO;

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User validateUser(String userName, String passWord) {
		// TODO Auto-generated method stub
		return userDAO.validateUser(userName, passWord);
	}

	@Override
	public Integer saveUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.saveUser(user);
	}

	@Override
	public Boolean checkUser(String userName) {
		// TODO Auto-generated method stub
		return userDAO.checkUser(userName);
	}

}
