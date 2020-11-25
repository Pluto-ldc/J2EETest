package org.easybooks.bookstore.service;

import org.easybooks.bookstore.vo.User;

public interface IUserService {

	/**
	 * 通过用户名和密码进行验证
	 * 
	 * @param userName 用户名
	 * @param passWord 密码
	 * @return User user ｜｜ null <br>
	 *         若查询到用户则返回该用户，若查询不到则返回null
	 */
	User validateUser(String userName, String passWord);

	/**
	 * 接收用户对象并保存到数据库
	 * 
	 * @param user 用户对象
	 * @return 若成功插入则返回新用户对象的主键值，失败则返回null
	 */
	Integer saveUser(User user);

	/**
	 * 通过用户名查询数据库是否存在此用户
	 * 
	 * @param userName 用户名
	 * @return 若存在则返回true，不存在则返回false
	 */
	Boolean checkUser(String userName);

}
