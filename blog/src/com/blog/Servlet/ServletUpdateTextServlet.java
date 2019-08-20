package com.blog.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.bean.Text;

import com.blog.services.SelectUpdateService;

import com.blog.servicesImpl.SelectUpdateImpl;

@WebServlet("/SelectUpdateTextServlet")
public class ServletUpdateTextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		if(id != null&&id.length()>0){
			//字符串转换成int类型
			int ID = Integer.parseInt(id);
			SelectUpdateService selectById = new SelectUpdateImpl();
			Text text = selectById.selectTextById(ID);
			if(text!=null){
				request.setAttribute("text", text);
				request.getRequestDispatcher("manage/updateText.jsp").forward(request,response);
			}else{
				System.out.println("查询失败");
			}
			
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
