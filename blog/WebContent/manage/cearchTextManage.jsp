<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.blog.bean.*" %>
<%@page import="com.blog.Servlet.SercletTextFiveById" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta name="description" content="谈同个人博客，本站会给大家不定时更新关于web前端的一些小技巧。如大家有不懂得问题，也可以与我们联系，我们会尽力帮助您。">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="../images/logo.png">
<meta charset="utf-8">
<meta charset="gb2312">
<meta name="keywords" content="个人博客" />
<meta name="keywords" content="博客搭建" />
<meta name="keywords" content="博客网站" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="baidu-site-verification" content="CtYt4injW1" />
<meta name="360-site-verification" content="a75dcb147688915b4cc7cfaa71e996a2" />
<title>谈同个人博客♠★♠一个前端设计的热血青年</title>
<meta name="keywords" content="谈同个人博客♠★♠一个前端设计的热血青年" />
<meta name="description" content="谈同个人博客♠★♠一个前端设计的热血青年" />
<link href="../css/base.css" rel="stylesheet">
<link href="../css/index.css" rel="stylesheet">
<%!
    	HttpSession session;
   		User user;
	%>
	<%
		session = request.getSession();
		user = (User)session.getAttribute("login");
		if(user==null||user.getUsername().equals("")){
			
	%>
	
	 <!-- -跳转页面的一种方法- -->
	   <script language="javascript"> 
		alert("请先登录！"); 
		top.location='index.jsp'; 
	   </script> 
	<%-- <jsp:forward page="login.jsp"/> --%>
	<% 
		}
	%> 

<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<link href="../css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>

<!--  <Sctipt type="text/javascript">
	var con = confirm();
</Sctipt> -->
</head>
<body>
<div class="topnav">
<a href="http://www.tthcclove.cn" target="_blank">谈同个人博客♠★♠一个前端设计的热血青年</a>――本站文章部分来自网络<a href="http://www.tthcclove.cn" target="_blank">如有涉嫌侵权，请与本站邮箱联系</a>
</div>
<div id="wrapper">
  <header>
    <div class="headtop"></div>
    <div class="contenttop">
      <div class="logo f_l">谈同个人博客♠★♠一个前端设计的热血青年</div>
      <div class="search f_r">
        <form action="/e/search/index.php" method="post" name="searchform" id="searchform">
          <input name="keyboard" id="keyboard" class="input_text" value="请输入关键字" style="color: rgb(153, 153, 153);" onfocus="if(value=='请输入关键字'){this.style.color='#000';value=''}" onblur="if(value==''){this.style.color='#999';value='请输入关键字'}" type="text">
        
          <input name="Submit" class="input_submit" value="搜索" type="submit">
        </form>
      </div>
      <div class="blank"></div>
      <nav>
        <div  class="navigation">
          <ul class="menu">
            <li><a href="../index.jsp">网站首页</a></li>
            <li><a href="#">关于我</a>
              <ul>
                <li><a href="../about.jsp">个人简介</a></li>
                <li><a href="../listpic.jsp">个人相册</a></li>
              </ul>
            </li>
            <li><a href="../index2.jsp">写博客</a>
              <ul>
                <li><a href="../newslistpic.jsp">个人日记</a></li>
                <li><a href="../newslistpic.jsp">学习笔记</a></li>
              </ul>
            </li>
            <li><a href="../404.jsp">技术文章</a> </li>
            <li><a href="../404.jsp">给我留言</a> </li>
          </ul>
        </div>
      </nav>
  <SCRIPT type=text/javascript>
	// Navigation Menu
	$(function() {
		$(".menu ul").css({display: "none"}); // Opera Fix
		$(".menu li").hover(function(){
			$(this).find('ul:first').css({visibility: "visible",display: "none"}).slideDown("normal");
		},function(){
			$(this).find('ul:first').css({visibility: "hidden"});
		});
	});
</SCRIPT>
    </div>
 </header>
 
     <div class="logo f_l">
		
   	<% 
		ArrayList<Text> list = (ArrayList)request.getAttribute("serchService");
		for(Text text:list){
			
		
	%> 
      <h4> 
      	<tr>
      		<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<%= text.getTitle() %></td>
      		<td>&nbsp&nbsp&nbsp&nbsp<a href="../deleteServlet?id=<%=text.getId() %> " class="btn btn-info">删除</a></td>
      		<td>&nbsp&nbsp<a data-toggle="modal" href="#static" class="btn btn-info" data-placement="bottom" data-original-title="查看客户详情">编辑</a></td>
      		<%-- <td>&nbsp&nbsp<a href="../SelectUpdateTextServlet?id=<%=text.getId() %>" class="btn btn-info">编辑</a></td> --%>
      	</tr>
      </h4>
      <br/>

     
      
    </div> 
</div>
	<!-- 模态框 -->
	<div id="static" class="modal hide fade" tabindex="-1" data-backdrop="static" data-keyboard="false" data-width="960">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			
				<h4 class="modal-title" id="myModalLabel">
					模态框（Modal）标题
				</h4>
			</div>
			<form action="../updateTextServlet" method="get">
			<div class="modal-body">
					<input id="b" type="hidden" value="<%=text.getId() %>" name="textId"/>
					<input id="a" style="border-radius:5px;" name="textName" placeholder="请输入新的文章标题"/>
			</div>
			
			<div class="modal-boyd">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="submit" class="btn btn-primary">
					提交更改
				</button>
			</div>
			</form>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div> 
  <%
		}
      %>  
</body>


	<style type="text/css">
	textarea {
    padding: 4px;
    border: solid 1px #E5E5E5;
    outline: 0;
    font: normal 13px/100% Verdana, Tahoma, sans-serif;
    width: 200px;
    background: #FFFFFF;
    box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;
    -moz-box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;
    -webkit-box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;    
	}
</style>
<style>
	
</style>
</html>

