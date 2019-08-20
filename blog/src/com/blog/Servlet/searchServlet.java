package com.blog.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

import com.blog.bean.Text;
import com.blog.services.SearchService;
import com.blog.servicesImpl.SearchServiceImpl;

/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("keyboard");
		if(title!=null&&title!=""){
			SearchService serchService = new SearchServiceImpl();
			List<Text> list = serchService.serchTitle(title);
			if(list!=null&&list.size()>0){
				request.setAttribute("serchService", list);
				request.getRequestDispatcher("manage/cearchTextManage.jsp").forward(request,response);
			}else{
				System.out.println("没有此文章");
			}
		}else{
			System.out.println("请输入标题");
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
