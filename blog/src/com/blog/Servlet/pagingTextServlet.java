package com.blog.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.bean.Manage;
import com.blog.bean.Text;
import com.blog.services.pagingTextService;
import com.blog.servicesImpl.pagingTexeImpl;
import com.mysql.jdbc.PingTarget;

/**
 * Servlet implementation class pagingTextServlet
 */
@WebServlet("/pagingTextServlet")
public class pagingTextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public pagingTextServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Manage manage = new Manage();
		int pageSize = Integer.parseInt(request.getParameter("page").trim());
		HttpSession session = request.getSession();
		HashMap map = new HashMap();
		if(pageSize>0){
			pagingTextService pagingText = new pagingTexeImpl();
			ArrayList<Text> list = (ArrayList) pagingText.pagingText(pageSize-1,10);
			
			//添加总页数
			manage.setPageCount(pagingText.getPageCount());
			
			//添加当前页面
			manage.setCurrentPage(pageSize);;
			if(list!=null&&list.size()>0){
			
				
				//查询文章
				map.put("1", list);
				
				//添加manage
				map.put("2",manage);
				
				
				session.setAttribute("manageRequest1", map);
				response.sendRedirect("manage/textManage.jsp");
			}
			
		}else{
				response.sendRedirect("manage/textManage.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
