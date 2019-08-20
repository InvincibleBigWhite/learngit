package com.blog.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.bean.Text;
import com.blog.services.SelectTextbyTitleServices;
import com.blog.servicesImpl.SelectTextbyTitleServicesImpl;

/**
 * Servlet implementation class SelectTextbyTitle
 */
@WebServlet("/SelectTextbyTitle")
public class SelectTextbyTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	//根据标题查询博文
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		
		PrintWriter out = response.getWriter();
		if(title!=null&&title.length()>0){
			
			SelectTextbyTitleServices textbyTitle = new SelectTextbyTitleServicesImpl();
			List<Text> list = textbyTitle.SelectTextByTitle(title);
			if(list!=null&&list.size()!=0){
				request.setAttribute("textByTitle", list);
				request.getRequestDispatcher("w3.jsp").forward(request,response);
			}else{
				
				out.print("失败失败");
			}
		}else{
			out.print("失败失败");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
