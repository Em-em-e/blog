package com.coderliang.base;

import java.sql.Connection;
import java.sql.DriverManager;
public class BaseDao {
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/blog";
	private static String user="root";
	private static String pwd="Ll0521609219";
	
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动加载失败");
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection con=null;
		try {
			con=DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection(Connection con){
		if(con!=null){
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
