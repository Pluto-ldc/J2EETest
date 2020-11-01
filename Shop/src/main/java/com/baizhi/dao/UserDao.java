package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.User;

public interface UserDao {
	// 查找所有用户
	public List<User> selectAll();

	// 添加用户
	public void insert(User user);

	// 删除用户
	public void delete(int id);

	// 通过ID查找用户
	public User selectById(int id);

	// 修改用户信息
	public void updateUser(User user);
}
