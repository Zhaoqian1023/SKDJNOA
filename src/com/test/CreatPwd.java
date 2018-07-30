package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.util.MD5Util;
import com.util.RandomUtil;


public class CreatPwd {
	private static String url="jdbc:mysql://localhost:3306/educationaloa" ;
	private static String username="root";
	private static String password="root";
	public static Connection conn=null;
	public static PreparedStatement pstmt = null;
	public static Statement stmt = null;
	public static ResultSet rs = null;
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
	
	public static List queryAllTypes(){
		List typeData = new ArrayList();
		conn  = getConnection();
		String sql = "select uid from t_users;";
		try {
			
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				typeData.add(rs.getInt("uid"));
			}
			return typeData;
			
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
		return null;
	}
	
	public static boolean updatePwd(List<us> list3) {
		// 连接数据库
		conn  = getConnection();
		String sql = "update t_users set password=? , pwd=?  where uid=?";
		System.out.println("+++++++++++");
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("222222222");
			
			for(us u1:list3){
				System.out.println("1111111");
				pstmt.setString(1, u1.getPassword());
				pstmt.setString(2, u1.getPwd());
				pstmt.setInt(3, u1.getUid());
				pstmt.executeUpdate();
				System.out.println("更新成功！！！！");
			}
			
		} catch (SQLException e) {
			System.out.println("checknews表插入失败！！");
		}finally{
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				System.out.println("关闭数据库失败！！");// TODO: handle exception
			}
		}
		return true;
	}
	public static void main(String[] args) {
		List li=queryAllTypes();
		List<us> sd= new ArrayList<us>(); 
		RandomUtil ru = new RandomUtil();
		for(int i=0;i<li.size();i++){
			us u= new us();
			String s= ru.genEasyPswd(8);
			String md5=MD5Util.getMD5(s);
			u.setUid(Integer.parseInt(li.get(i).toString()));
			u.setPassword(md5);
			u.setPwd(s);
			sd.add(u);
			System.out.println(u.getUid()+"  "+u.getPassword()+"  "+u.getPwd());
		}
		updatePwd(sd);

	}

}
