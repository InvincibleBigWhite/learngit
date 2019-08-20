package com.blog.servicesImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.bean.Text;
import com.blog.conn.Util;
import com.blog.services.SelectText;

public class SelectTextImpl implements SelectText {
	
	private Connection conn = null;
	private PreparedStatement pram;
	private ResultSet rs;
	
	public SelectTextImpl(){
		try {
			conn = Util.getConn();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	//查询文章
	@Override
	public List<Text> selectFiveByIdText() {
		ArrayList <Text> text = new ArrayList<Text>();
		
		try {
			pram = conn.prepareStatement("select * from text order by id desc limit 5 ");
			rs = pram.executeQuery();
			while(rs.next()){
				Text t = new Text();
				t.setId(rs.getInt("id"));
				t.setTitle(rs.getString("title"));
				t.setText(rs.getString("text"));
				text.add(t);
				
			}
			return text;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}
	}

}
