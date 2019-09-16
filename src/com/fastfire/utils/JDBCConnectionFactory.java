package com.fastfire.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionFactory {

	public static Connection getConnection() {
		
		String connectionURL = "jdbc:sqlserver://DESKTOP-EOUN969:1433;databaseName=College;user=root;password=root;";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Exception while registering SQL Driver");
			e.printStackTrace();
		}
		
		try {
			return DriverManager.getConnection(connectionURL);
		} catch (SQLException e) {
			System.out.println("Exception during JDBC connection");
			e.printStackTrace();
		}
		
		return null;
	}

}
