package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Admin;

public interface AdminDao {

	public Admin selectByName(@Param("userName") String userName);

	public void insert(Admin admin);

}
