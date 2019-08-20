package com.blog.servicesImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.blog.conn.Util;
import com.blog.services.DeleteService;

public class DeleteServiceImpl implements DeleteService {
	private static Connection conn = null;
	private PreparedStatement pram;
	
	public DeleteServiceImpl() {
		try {
			conn = Util.getConn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//删除文章
	@Override
	public boolean deleteById(int iD) {
		try {
			pram = conn.prepareStatement("delete from text where id=?");
			pram.setInt(1,iD);
			pram.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
}
