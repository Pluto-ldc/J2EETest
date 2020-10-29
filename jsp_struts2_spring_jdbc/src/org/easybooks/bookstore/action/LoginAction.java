package org.easybooks.bookstore.action;

import java.sql.ResultSet;

import org.easybooks.bookstore.jdbc.MySQLConnBean;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {

	private String userName;

	private String passWord;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String execute() throws Exception {
		String userName = getUserName();
		String passWord = getPassWord();
		boolean validated = false;
		MySQLConnBean mySQLConnBean = new MySQLConnBean();

		String sql = "select * from user";
		mySQLConnBean.openConn();
		ResultSet resultSet = mySQLConnBean.executeQuery(sql);
		while (resultSet.next()) {
			if (resultSet.getString("userName").compareTo(userName) == 0
					&& resultSet.getString("passWord").compareTo(passWord) == 0) {
				validated = true;
				break;
			}
		}
		resultSet.close();
		mySQLConnBean.closeStatement();
		mySQLConnBean.closeConnection();
		if (validated) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

}
