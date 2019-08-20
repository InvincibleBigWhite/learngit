package com.blog.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.blog.bean.User;
import com.blog.services.LoginServices;
import com.blog.servicesImpl.LoginServicesImpl;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public loginServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String[] jiZhuUser = request.getParameterValues("loginCookie");
		for(int i =0;i<jiZhuUser.length;i++){
			System.out.println(jiZhuUser[i]);
		}
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		if((username!=null || username!="")&&(password != null || password!="")){
			LoginServices longin = new LoginServicesImpl();
			//判断是否是记住密码
			if(jiZhuUser!=null&&jiZhuUser.length>0){
				//创建Cookie保存用户以及密码
				Cookie usernameCookie = new Cookie("username", username);
				Cookie passwordCookie = new Cookie("password", password);
				response.addCookie(usernameCookie);
				response.addCookie(passwordCookie);
				usernameCookie.setMaxAge(86400);
				passwordCookie.setMaxAge(86400);
				
			}else{
				Cookie[] cookies = request.getCookies();
				for(Cookie c:cookies){
					if(c.getName().equals("username")||c.getName().equals("password")){
						c.setMaxAge(0);
						response.addCookie(c);
					
					}
				}
				
			}
			if(longin.loginUser(user)){
				session.setAttribute("login", user);
				response.sendRedirect("index.jsp");
			}else{
				response.sendRedirect("login.jsp");
			}
			
		}else{
			response.sendRedirect("login.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
