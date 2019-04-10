package com.cognizant.assistant.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static final String 
			URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String driverName = "oracle.jdbc.driver.OracleDriver"; 
	public static final String userName = "ROAD";
	public static final String password = "root";
	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(URL,userName,password);
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void closeConnection(Connection connection ) {
		
	}
}
