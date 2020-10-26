package com.pluto.utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

	private static final ComboPooledDataSource datasource =new ComboPooledDataSource();
	
	public static Connection getConnection() throws SQLException{
		
		return datasource.getConnection();
		
	}
	
	public static DataSource getDataSource() {
		
		return datasource;
		
	}
}
