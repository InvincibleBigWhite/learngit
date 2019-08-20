package com.blog.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.bean.Text;
import com.blog.bean.User;
import com.blog.services.AddText;
import com.blog.servicesImpl.AddTextServicesImpl;


@WebServlet("/UeditorServlet")
public class UeditorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UeditorServlet() {
        super();
     
    }

    //保存博文到数据库
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String a = request.getParameter("editorValue");
		String biaoti = request.getParameter("biaoti");
		Text text = new Text();
		text.setTitle(biaoti);
		text.setText(a);
		if(a!=null&&a.length()>0){
			AddText addtext = new AddTextServicesImpl();
			if(addtext.addText(text)){
				response.sendRedirect("index.jsp");
			}else{
				response.getWriter().print("保存失败！！！");
			}
			//request.setAttribute("text", a);
			//request.getRequestDispatcher("w4.jsp").forward(request, response);
		}else{
			response.getWriter().append("没有内容");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
