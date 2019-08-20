package com.blog.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.blog.bean.Manage;
import com.blog.bean.Text;
import com.blog.services.ManageText;
import com.blog.servicesImpl.ManageTextServiceImpl;

@WebServlet("/ManageTextServlet")
public class ManageTextServlet extends HttpServlet {
	private int pageSize = 10;//默认页面条数
	private int number = 0;//默认开始条数
	private int page =	1;//默认当前页数 	  
	
	public ManageTextServlet(){
		super();
	}
	
	private static final long serialVersionUID = 1L;
	//根据标题查询博文
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			System.out.println("-----------------");
			HttpSession session = request.getSession();
			Manage manage = new Manage();
			ManageText m = new ManageTextServiceImpl();
			List<Text> list = m.manageText(number,pageSize);
			HashMap map = new HashMap();
			
			if(list != null&&list.size()>0){
				//添加总页数
				manage.setPageCount(m.getPageCount());
				
				//添加当前页面
				manage.setCurrentPage(page);;
				
				//查询文章
				map.put("1", list);
				
				//添加manage
				map.put("2",manage);
				
				
				session.setAttribute("manageRequest1", map);
				response.sendRedirect("manage/textManage.jsp");
			}else{
				PrintWriter out = response.getWriter();
				out.print("失败失败");
			}
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

}
