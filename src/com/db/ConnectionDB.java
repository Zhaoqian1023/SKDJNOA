package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	/**
	 * @author victor
	 * @see
	 * 数据库连接类
	 * 
	 */
	private static String url="jdbc:mysql://localhost:3306/educationaloa" ;
	private static String username="root";
	private static String password="root";
	public static Connection conn=null;
	
	public static Connection getConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
		}
		return conn;
	}
	

}
