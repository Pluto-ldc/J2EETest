package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
	// 登录判断
	public Admin login(String name);

	// 注册
	public void register(Admin admin);

}
