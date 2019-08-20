package com.blog.servicesImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.bean.Text;
import com.blog.conn.Util;
import com.blog.services.SelectTextbyTitleServices;

public class SelectTextbyTitleServicesImpl implements SelectTextbyTitleServices{
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
	public List SelectTextByTitle(String title) {
		List list = new ArrayList();
		try {
			pram = conn.prepareStatement("select * from text where title=?");
			pram.setString(1,title);
			rs = pram.executeQuery();
			while(rs.next()){
				Text text = new Text();
				text.setId(rs.getInt(1));
				text.setTitle(rs.getString(2));
				text.setText(rs.getString(3));
				list.add(text);
			}
			return list;
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
