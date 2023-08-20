package com.student;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtils {
	
	
	public static Connection getConnection(){  
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cij-77", "root",
					"password");
			// 127.0.0.1
			 
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
		
	}

}
