package org.easybooks.bookstore.service;

import org.easybooks.bookstore.vo.User;

public interface IUserService {

	public User validateUser(User user);

	public User registerUser(User user);

}
