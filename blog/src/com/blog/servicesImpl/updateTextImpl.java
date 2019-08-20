package com.blog.servicesImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.blog.conn.Util;
import com.blog.services.updateTextServletService;

public class updateTextImpl implements updateTextServletService {
	private static  Connection conn;
	private PreparedStatement pram;

	static{
		try {
			conn = Util.getConn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean updateText(int id, String textName) {
		try {
			pram = conn.prepareStatement("update text set title=? where id=?");
			pram.setString(1, textName);
			pram.setInt(2, id);
			pram.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				pram.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
