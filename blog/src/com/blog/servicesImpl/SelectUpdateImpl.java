package com.blog.servicesImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.blog.bean.Text;
import com.blog.conn.Util;
import com.blog.services.SelectUpdateService;

public class SelectUpdateImpl implements SelectUpdateService {
	private static Connection conn = null;
	private PreparedStatement pram;
	private ResultSet rs;
	
	static{
		try {
			conn = Util.getConn();
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
	}

	@Override
	public Text selectTextById(int id) {
		Text text = new Text();
		try {
			pram = conn.prepareStatement("select * from text where id=?");
			pram.setInt(1, id);
			rs = pram.executeQuery();
			while(rs.next()){
				text.setId(rs.getInt(1));
				text.setTitle(rs.getString(2));
				text.setText(rs.getString(3));
			}
			return text;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				pram.close();
				rs.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
}
