package org.easybooks.bookstore.dao;

import org.easybooks.bookstore.vo.User;

public interface IUserDAO {

	public User validate(User user);

	public Integer saveUser(User user);
	
}
