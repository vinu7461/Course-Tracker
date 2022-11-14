package com.ct.utility;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

	
	public static Connection provideConnection() {
		
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			System.out.println("DB Not connected");
			System.out.println("problen with loading the driver related class");
			e.printStackTrace();
		}
		
		String url="jdbc:mysql://localhost:3306/CourseTrackerDB";
		
		   try {
		conn=DriverManager.getConnection(url, "root", "v9168");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Not connected");
		}
		
		
		return conn;
		
	};
	
}
