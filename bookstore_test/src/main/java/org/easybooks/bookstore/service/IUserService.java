package org.easybooks.bookstore.service;

import org.easybooks.bookstore.vo.User;

public interface IUserService {
	
	public User validateUser(String username, String password);

	public void saveUser(User user);

	public boolean exitUser(String username);
	
}
