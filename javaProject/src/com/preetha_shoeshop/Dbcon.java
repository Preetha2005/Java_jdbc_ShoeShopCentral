package com.preetha_shoeshop;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbcon {
	public Connection getDBConnection() {
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");

		}catch(Exception ex) {
		System.out.println(ex);
		}
		return con;

		}

}
