package org.easybooks.bookstore.service.impl;

import org.easybooks.bookstore.dao.IUserDAO;
import org.easybooks.bookstore.service.IUserService;
import org.easybooks.bookstore.vo.User;

public class UserService implements IUserService{
	private IUserDAO userDAO;
	public void saveUser(User user){
		this.userDAO.saveUser(user);
	}
	public User validateUser(String username, String password) {
		
		return userDAO.validateUser(username, password);
	}
	
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public boolean exitUser(String username) {
		return userDAO.exitUser(username);
	}

}
