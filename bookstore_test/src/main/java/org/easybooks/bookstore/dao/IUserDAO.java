package org.easybooks.bookstore.dao;

import org.easybooks.bookstore.vo.User;

public interface IUserDAO {
	//验证用户登录信息
	public User validateUser(String username,String password);
	//注册时验证用户信息
	public void saveUser(User user);
	//注册时判断用户名是否已经存在
	public boolean exitUser(String username);
}