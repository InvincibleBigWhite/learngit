package com.blog.servicesImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.bean.Text;
import com.blog.conn.Util;
import com.blog.services.SearchService;

import jdk.nashorn.internal.objects.annotations.Where;


public class SearchServiceImpl implements SearchService{
	private Connection conn;
	private PreparedStatement pram;
	private ResultSet rs;
	
	public SearchServiceImpl() {
		try {
			conn = Util.getConn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Text> serchTitle(String title) {
		ArrayList<Text> text = new ArrayList<Text>();
		String i ="%"+title+"%";
		try {
			pram = conn.prepareStatement("select * from text where title like ?");
			pram.setString(1, i);
			rs = pram.executeQuery();
			while(rs.next()){
				Text t = new Text();
				t.setId(rs.getInt("id"));
				t.setTitle(rs.getString("title"));
				t.setText(rs.getString("text"));
				text.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			try {
				rs.close();
				pram.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return text;
	}

}
