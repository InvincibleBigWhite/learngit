package com.blog.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
	private static String username = "root";
	private static String password = "123456";
	private static String url = "jdbc:mysql://localhost:3306/blog?&useUnicode=true&characterEncoding=UTF8";
	private static Connection conn = null;
	
	//加载数据库驱动
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
	}
	
	//获取数据库对象
	public static Connection getConn() throws Exception{
		if(conn == null){
			conn = DriverManager.getConnection(url,username,password);
		}else{
			return conn;
		}
		return conn;
	}
}
