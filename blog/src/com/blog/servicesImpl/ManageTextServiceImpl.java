package com.blog.servicesImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.Servlet.ManageTextServlet;
import com.blog.bean.Text;
import com.blog.conn.Util;
import com.blog.services.ManageText;

public class ManageTextServiceImpl implements ManageText {
	Connection conn;
	PreparedStatement pram;
	private ResultSet rs;
	
	public ManageTextServiceImpl() {
		try {
			conn = Util.getConn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Text> manageText(Integer i,Integer j) {
		List<Text> list = new ArrayList<Text>(); 
		try {
			pram  = conn.prepareStatement("select * from text limit ?,?");
			pram.setInt(1, i*10);
			pram.setInt(2, j);
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
				rs.close();
				pram.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//查询总页数
	public int getPageCount(){
		int page = 1;//总页数
		int n = 0;//总数据条数
		try {
			pram = conn.prepareStatement("select count(*) from text");
			rs = pram.executeQuery();
			
			//查询总条数
			while(rs.next()){
				n = rs.getInt(1);
			}
			
			//计算总页数
			if(n%10 == 0){
				page = n/10;
			}else{
				page = n/10+1;
			}
			return page;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}finally{
			try {
				rs.close();
				pram.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
}
