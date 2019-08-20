package com.blog.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.services.updateTextServletService;
import com.blog.servicesImpl.updateTextImpl;

/**
 * Servlet implementation class updateTextServlet
 */
@WebServlet("/updateTextServlet")
public class updateTextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String id = request.getParameter("textId");
		String textName = request.getParameter("textName");
		
		//修改标题
		if((textName!=null||textName!="")&&(id!=null||id!="")){
			int ID = Integer.parseInt(id);
			updateTextServletService updateText = new updateTextImpl(); 
			if(updateText.updateText(ID, textName)){
				System.out.println("修改成功");
				response.sendRedirect("ManageTextServlet");
			}else{
				System.out.println("修改失败！");
				response.sendRedirect("ManageTextServlet");
			}
			
		}else{
			System.out.println("修改失败！");
			response.sendRedirect("manage/textManage.jsp");
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
