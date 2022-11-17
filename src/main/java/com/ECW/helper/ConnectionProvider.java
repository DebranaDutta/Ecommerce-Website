package com.ECW.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "Debrana@95");
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
}
