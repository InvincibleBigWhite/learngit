package com.blog.servicesImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.blog.bean.Text;
import com.blog.conn.Util;
import com.blog.services.AddText;

public class AddTextServicesImpl implements AddText {
	private Connection conn = null;
	private PreparedStatement pram;
	private ResultSet rs;
	
	public AddTextServicesImpl(){
		try {
			conn = Util.getConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean addText(Text text) {
		try {
			pram = conn.prepareStatement("insert into text(title,text) values(?,?)");
			pram.setString(1,text.getTitle());
			pram.setString(2, text.getText());
			pram.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			try {
				pram.close();
				//rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

}
