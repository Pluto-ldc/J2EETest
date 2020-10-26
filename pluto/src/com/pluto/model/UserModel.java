package com.pluto.model;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.pluto.domain.User;
import com.pluto.utils.JDBCUtils;

public class UserModel {

	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

	public User login(User user) throws Exception {
		String sql = "SELECT * FROM user WHERE userName = ? AND passWord = ?";
		User exsitUser = queryRunner.query(sql, new BeanHandler<User>(User.class), user.getUserName(),
				user.getPassWord());
		return exsitUser;
	}

	public Integer register(User user) throws Exception {
		String sql = "INSERT INTO `test`.`user`(`id`, `userName`, `passWord`) VALUES (?, ?, ?)";
		Integer num = queryRunner.execute(sql, user.getId(), user.getUserName(), user.getPassWord());
		return num;
	}

	public Long selectUserByUserName(String userName) throws Exception {
		String sql = "SELECT COUNT(*) FROM user WHERE userName = ?";
		List<Long> list = queryRunner.execute(sql, new ScalarHandler<Long>(), userName);
		return list.get(0);
	}

}
