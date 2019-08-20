package com.blog.servicesImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.blog.bean.User;
import com.blog.conn.Util;
import com.blog.services.LoginServices;


public class LoginServicesImpl implements LoginServices {
	private static Connection conn = null;
	private PreparedStatement pram;
	private ResultSet re;
	
	static{
		try {
		
			conn = Util.getConn();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
	}
		
	@Override
	public boolean loginUser(User user) {
		try {
			pram = conn.prepareStatement("select * from bloguser where username=? and password=?");
			pram.setString(1, user.getUsername());
			pram.setString(2, user.getUsername());
			re = pram.executeQuery();
			if(re.next()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				pram.close();
				re.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
