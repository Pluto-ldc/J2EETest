package shop.model;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import shop.domain.User;
import shop.utils.JDBCUtils;

public class UserModel {

	/**
	 * 接受user对象，通过用户名密码查找数据库 查询到结果即为登陆成功
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User login(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "SELECT * FROM user WHERE userName = ? AND passWord = ?";
		User exsitUser = queryRunner.query(sql, new BeanHandler<User>(User.class), user.getUserName(),
				user.getPassWord());
		;
		return exsitUser;
	}

	/**
	 * 接收user对象，通过用户名查找数据库，若已存在同名用户 返回True 不存在则返回False
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public boolean checkUserNameRepeat(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "SELECT * FROM user WHERE userName = ? ";
		User exsitUser = queryRunner.query(sql, new BeanHandler<User>(User.class), user.getUserName());
		if (exsitUser == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 通过传入user对象一一赋值进行插入
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public boolean register(User user) throws SQLException {
		int money = 1000;
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "INSERT INTO `bookshop`.`user`(`userName`, `passWord`, `money`, `name`, `sex`, `email`, `mobile`) VALUES ( ?, ?, ?, ?, ?, ?, ?);";
		int num = queryRunner.execute(sql, user.getUserName(), user.getPassWord(), money, user.getName(), user.getSex(),
				user.getEmail(), user.getMobile());
		if (num > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean editUserInfo(User user) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "UPDATE `bookshop`.`user` SET `userName` = ?, `name` = ?, `sex` = ?, `email` = ?, `mobile` = ? WHERE `id` = ?;";
		int num = 0;
		try {
			num = queryRunner.execute(sql, user.getUserName(), user.getName(), user.getSex(), user.getEmail(),
					user.getMobile(),user.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean updateUserPwd(User user) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "UPDATE `bookshop`.`user` SET `passWord` = ? WHERE `id` = ?;";
		int num = 0;
		try {
			num = queryRunner.execute(sql, user.getPassWord(),user.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		} else {
			return false;
		}
	}

}
