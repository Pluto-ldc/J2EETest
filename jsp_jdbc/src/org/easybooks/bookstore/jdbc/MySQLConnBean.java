package org.easybooks.bookstore.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnBean {

	private Statement statement = null;
	private Connection connection = null;
	private ResultSet resultSet = null;

	public MySQLConnBean() {
	}

	public void openConn() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql:///test?useSSL=false&characterEncoding=UTF-8";
			String user = "pluto";
			String passWord = "Ldc0504.@";
			connection = DriverManager.getConnection(url, user, passWord);
		} catch (Exception e) {
			System.err.println("Data.executeQuery:" + e.getMessage());
		}
	}

	public ResultSet executeQuery(String sql) {
		resultSet = null;
		try {
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			resultSet = statement.executeQuery(sql);
		} catch (Exception e) {
			System.err.println("Data.executeQuery:" + e.getMessage());
		}
		return resultSet;
	}

	public void closeStatement() {
		try {
			statement.close();
		} catch (Exception e) {
			System.err.println("Data.executeQuery:" + e.getMessage());
		}
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (Exception e) {
			System.err.println("Data.executeQuery:" + e.getMessage());
		}
	}

}
