package com.FlyAway.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FlyDBConnect {

	public static Connection getConnection() throws SQLException {

		Connection con = null;
		String jdbcUrl = "jdbc:mysql://localhost:3306/simplilearn2?useSSL=false";
		String driver = "com.mysql.cj.jdbc.Driver";
		String user = "root";
		String password = "SPkraja720";


		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(jdbcUrl, user, password);

		}catch(Exception e)
		{

			e.printStackTrace();
		}

		return con;
	}

	/*
	public static void main(String[] args) {

			getConnection();
			System.out.println("Connection Established");

	}
	 */

}
