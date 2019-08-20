package com.blog.Servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.bean.Text;
import com.blog.services.SelectText;
import com.blog.servicesImpl.SelectTextImpl;


@WebServlet("/SercletTextFiveById")
public class SercletTextFiveById extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("DEbug");
		HttpSession session = request.getSession();
		SelectText selectText = new SelectTextImpl();
		List<Text> list  = selectText.selectFiveByIdText();
	
		if(list!=null){
			session.setAttribute("five", list);
			//request.setAttribute("five", list);
			//request.getRequestDispatcher("index.jsp").forward(request, response);
		
		}else{
			System.out.println("没有数据");
		}
		
	}

	
}
