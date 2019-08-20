package com.blog.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.services.DeleteService;
import com.blog.servicesImpl.DeleteServiceImpl;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		if(id != null&&id.length()>0){
			//字符串转换成int类型
			int ID = Integer.parseInt(id);
			DeleteService deleteById = new DeleteServiceImpl();
			
			if(deleteById.deleteById(ID)){
				System.out.println("删除成功");
				response.sendRedirect("ManageTextServlet");
			}else {
				System.out.println("删除失败");
				response.sendRedirect("manage/textManage.jsp");
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
