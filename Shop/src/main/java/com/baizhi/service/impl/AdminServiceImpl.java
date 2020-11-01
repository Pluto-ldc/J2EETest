package com.baizhi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;

	/**
	 * 登录功能： 通过用户名查询用户，若不存在则登录失败，若存在则验证用户密码是否一致，若不一致则登录失败，若都符合，登陆成功
	 */
	@Override
	public Admin login(String name) {
		return adminDao.selectByName(name);
	}

	@Override
	public void register(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.insert(admin);
	}

}
