package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class TempDao {
	private static String url="jdbc:mysql://localhost:3306/educationaloa" ;
	private static String username="root";
	private static String password="root";
	public static Connection conn=null;
	public static Statement stmt = null;
	public static ResultSet rs = null;
	
	public static Connection getConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
		}
		return conn;
	}
	public static boolean createFile(String URL){
		conn = getConnection();
		String sql = "select * into outfile '"+URL+"' from t_scoremanagement ";
		System.out.println(sql);
		try {
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("acquire statement object failed!");
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("DB connection close failed！");
			}
		}
		return false;
	}

}
