<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.blog.bean.*" %>
<%@page import="com.blog.Servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta name="description" content="谈同个人博客，本站会给大家不定时更新关于web前端的一些小技巧。如大家有不懂得问题，也可以与我们联系，我们会尽力帮助您。">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="images/logo.png">
<meta charset="utf-8">

<meta name="keywords" content="个人博客" />
<meta name="keywords" content="博客搭建" />
<meta name="keywords" content="博客网站" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="baidu-site-verification" content="CtYt4injW1" />
<meta name="360-site-verification" content="a75dcb147688915b4cc7cfaa71e996a2" />
<title>谈同个人博客♠★♠一个前端设计的热血青年</title>
<meta name="keywords" content="谈同个人博客♠★♠一个前端设计的热血青年" />
<meta name="description" content="谈同个人博客♠★♠一个前端设计的热血青年" />
<link href="css/base.css" rel="stylesheet">
<link href="css/indexLogin.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>

</head>

<body>
<div class="topnav">
<a href="http://www.tthcclove.cn" target="_blank">谈同个人博客♠★♠一个前端设计的热血青年</a>――本站文章部分来自网络<a href="http://www.tthcclove.cn" target="_blank">如有涉嫌侵权，请与本站邮箱联系</a>
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	 <%
          request.setCharacterEncoding("UTF-8");
      		response.setCharacterEncoding("UTF-8");
          if(request.getSession().getAttribute("login")!=null){
        	  
           %>
          <a href="exitServlet">退出登录</a>
          <%} %>
</div>
<div id="wrapper">
  <header>
    <div class="headtop"></div>
    <div class="contenttop">
      <div class="logo f_l">谈同个人博客♠★♠一个前端设计的热血青年</div>
      <div class="search f_r">
      	
        <form action="searchServlet" method="post" name="searchform" id="searchform">
         
          <input name="keyboard" id="keyboard" class="input_text" value="请输入关键字" style="color: rgb(153, 153, 153);" onfocus="if(value=='请输入关键字'){this.style.color='#000';value=''}" onblur="if(value==''){this.style.color='#999';value='请输入关键字'}" type="text">
        
          <input name="Submit" class="input_submit" value="搜索" type="submit">
        
        </form>
      </div>
      <div class="blank"></div>
      <nav>
        <div  class="navigation">
          <ul class="menu">
            <li><a href="index.jsp">网站首页</a></li>
            <li><a href="#">关于我</a>
              <ul>
                <li><a href="about.jsp">个人简介</a></li>
                <li><a href="listpic.jsp">个人相册</a></li>
              </ul>
            </li>
            <li><a href="index2.jsp">写博客</a>
              <ul>
                <li><a href="newslistpic.jsp">个人日记</a></li>
                <li><a href="newslistpic.jsp">学习笔记</a></li>
              </ul>
            </li>
            <li><a href="ManageTextServlet">文章管理</a> </li>
            <li><a href="404.jsp">给我留言</a> </li>
           <li> <a class="nav-login" href="login.jsp">用户登录</a></li>  
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
  <div class="jztop"></div>
  <div class="container">
    <div class="bloglist f_l">

<%	
	
	new SercletTextFiveById().doGet(request,response);
	int i=0;
	List<Text> list = (List)session.getAttribute("five");
	for(Text text:list){
		 i++;
%>

<!--     @@@@第一篇文章开始@@@@-->
      <h3><a href="SelectTextbyTitle?title=<%=text.getTitle()%>" target="_blank"><%= text.getTitle()%></a></h3>
      <figure><img src="images/img_<%=i %>.jpg" alt="【从前端菜鸟到大神】一片总结的很好的文章"></figure>
      <ul>
        <p>结合个人经历总结的前端入门方法，总结从零基础到具备前端基本技能的道路、学习方法、资料。由于能力有限，不能保证面面俱到，只是作为入门参考，面向初学者，让初学者少走弯路。</p>
        <a title="【从前端菜鸟到大神】一片总结的很好的文章" href="w1.jsp" target="_blank" class="readmore">阅读全文&gt;&gt;</a>
      </ul>
      <p class="dateview"><span>2017-10-13</span><span>作者：谈同</span><span>个人博客：[<a href="/jstt/bj/">前端笔记</a>]</span></p>
      <h3><a href="/jstt/bj/2015-01-09/740.html"></a></h3>
		
	
<%
	}
%>
   


      <h3><a href="w6.html">【我的经历】…</a></h3>
      <figure><img src="images/logo.png" alt="【我的经历】…"></figure>
      <ul>
        <p>博客从最初的域名购买，到上线已经有半年的时间了，这半年的时间，有笑过，有怨过，有悔过，有执着过，也有放弃过…但最后还是坚持了下来，时间如此匆匆，等再回过头已来不及去弥补....
            <br><br>
            <h1><a href="http:www.tthcclove.cn" style="color:#444">谈同个人博客</a>
            </h1>
        </p>
        <a title="【我的经历】…" href="w6.html" target="_blank" class="readmore">阅读全文&gt;&gt;</a>
      </ul>
      <p class="dateview"><span>2017-04-09</span><span>作者：谈同</span><span>个人博客：[<a href="/jstt/bj/">心得笔记</a>]</span></p>
    </div>

    <!--首页主要文章部分结束-->

    <div class="r_box f_r">
      <div class="tit01">
        <h3 class="tit">关注我</h3>
        <div class="gzwm">
          <ul>
            <li><a class="email" href="tel:15594992776" target="_blank">我的电话</a></li>
            <li><a class="qq" href="mailto:157956315@qq.com" target="_blank">我的邮箱</a></li>
            <li><a class="tel" href="http://wpa.qq.com/msgrd?v=3&uin=34691068&site=qq&menu=yes" target="_blank" >我的QQ</a></li>
      		<!-- <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=995769733&amp;site=qq&amp;menu=yes">点这里给我发消息</a> --> 
 			<!-- <li><a href="http://wpa.qq.com/msgrd?V=1&Uin=995769733&Site=百度知道&Menu=yes" target="_blank"><img src="http://wpa.qq.com/pa?p=1:你的QQ号码:4" border="0" alt="QQ" /></a></li> -->
            <li><a class="prize" href="#" title="个人奖项">个人奖项</a></li>
          </ul>
        </div>
      </div>
      <!--tit01 end-->

      <div class="tuwen">
        <h3 class="tit">图文推荐</h3>
        <ul>
          <li><a href="404.html"><img src="images/02.jpg"><b>H5新属性</b></a>
            <p><span class="tulanmu"><a href="404.html">PC代码</a></span><span class="tutime">2015-02-15</span></p>
          </li>
          <li><a href="404.html"><img src="images/02.jpg"><b>教你怎样用欠费手机拨打电话</b></a>
            <p><span class="tulanmu"><a href="404.html">手机配件</a></span><span class="tutime">2015-02-15</span></p>
          </li>
          <li><a href="404.html" title="手机的16个惊人小秘密，据说99.999%的人都不知"><img src="images/3.jpeg" width="100" width="70" height="57"><b>手机的16个惊人小秘密，据说...</b></a>
            <p><span class="tulanmu"><a href="404.html">手机配件</a></span><span class="tutime">2015-02-15</span></p>
          </li>
          <li><a href="404.html"><img src="images/06.jpg"><b>住在手机里的朋友</b></a>
            <p><span class="tulanmu"><a href="404.html">手机配件</a></span><span class="tutime">2015-02-15</span></p>
          </li>
          <li><a href="404.html"><img src="images/04.jpg"><b>教你怎样用欠费手机拨打电话</b></a>
            <p><span class="tulanmu"><a href="404.html">手机配件</a></span><span class="tutime">2015-02-15</span></p>
          </li>
          <li><a href="404.html"><img src="images/02.jpg"><b>教你怎样用欠费手机拨打电话</b></a>
            <p><span class="tulanmu"><a href="404.html">手机配件</a></span><span class="tutime">2015-02-15</span></p>
          </li>
          <li><a href="404.html" title="手机的16个惊人小秘密，据说99.999%的人都不知"><img src="images/3.jpeg" width="70" height="57"><b>手机的16个惊人小秘密，据说...</b></a>
            <p><span class="tulanmu"><a href="404.html">手机配件</a></span><span class="tutime">2015-02-15</span></p>
          </li>
        </ul>
      </div>
      <div class="ph">
        <h3 class="tit">点击排行</h3>
        <ul class="rank">
          <li><a href="404.html" title="【心路历程】一篇关于设计理念的文章" target="_blank">【心路历程】一篇关于设计理念的文章</a></li>
          <li><a href="404.html" title="IP要突破2000+了" target="_blank">IP要突破2000+了</a></li>
          <li><a href="404.html" title="帝国cms首页、自定义页面如何实现分页" target="_blank">帝国cms首页、自定义页面如何实现分页</a></li>
          <li><a href="404.html" title="【已评选】给我模板PSD源文件，我给你设计HTML！" target="_blank">【已评选】给我模板PSD源文件，我给你设计HTML！</a></li>
          <li><a href="404.html" title="【郑重申明】本站只提供静态模板下载！" target="_blank">【郑重申明】本站只提供静态模板下载！</a></li>
          <li><a href="404.html" title="【孕期日记】生活本该如此" target="_blank">【孕期日记】生活本该如此</a></li>
          <li><a href="404.html" title="【【深入理解html5系列-文本标签】…" target="_blank">【【深入理解html5系列-文本标签】…</a></li>
          <li><a href="404.html" title=" 2014年度优秀个人博客排名公布" target="_blank"> 2014年度优秀个人博客排名公布</a></li>
          <li><a href="404.html" title="2014年度优秀个人博客评选活动" target="_blank">2014年度优秀个人博客评选活动</a></li>
          <li><a href="/404.html" title="使用CSS3制作文字、图片倒影" target="_blank">使用CSS3制作文字、图片倒影</a></li>
          <li><a href="404.html" title="【分享】css3侧边栏导航不同方向划出效果" target="_blank">【分享】css3侧边栏导航不同方向划出效果</a></li>
          <li><a href="404.html" title="分" target="_blank">分</a></li>
        </ul>
      </div>
      <div class="ad"> <img src="images/xifu.jpeg" height="300" width="110"> </div>
    </div>
  </div>

  <!-- container代码 结束 -->
  <div class="jzend"></div>

<div class="comment">
    <div id="SOHUCS"></div>
<script type="text/javascript">
(function(){
var appid = 'cytk2a7nr';
var conf = '3437d86f4a4e9bf3aad1ef65fc2740b5';
var width = window.innerWidth || document.documentElement.clientWidth;
if (width < 960) {
window.document.write('<script id="changyan_mobile_js" charset="utf-8" type="text/javascript" src="http://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=' + appid + '&conf=' + conf + '"><\/script>'); } else { var loadJs=function(d,a){var c=document.getElementsByTagName("head")[0]||document.head||document.documentElement;var b=document.createElement("script");b.setAttribute("type","text/javascript");b.setAttribute("charset","UTF-8");b.setAttribute("src",d);if(typeof a==="function"){if(window.attachEvent){b.onreadystatechange=function(){var e=b.readyState;if(e==="loaded"||e==="complete"){b.onreadystatechange=null;a()}}}else{b.onload=a}}c.appendChild(b)};loadJs("http://changyan.sohu.com/upload/changyan.js",function(){window.changyan.api.config({appid:appid,conf:conf})}); } })(); </script>

<!--PC版-->
<div id="SOHUCS" sid="" ></div>
<script charset="utf-8" type="text/javascript" src="https://changyan.sohu.com/upload/changyan.js" ></script>
<script type="text/javascript">
window.changyan.api.config({
appid: 'cytk2a7nr',
conf: '3437d86f4a4e9bf3aad1ef65fc2740b5'
});
</script>

<!--PC和WAP自适应版-->
<div id="SOHUCS" sid="请将此处替换为配置SourceID的语句" ></div>
<script type="text/javascript">
(function(){
var appid = 'cytk2a7nr';
var conf = 'prod_53c868f5f3ac56a10e72d038ac860764';
var width = window.innerWidth || document.documentElement.clientWidth;
if (width < 960) {
window.document.write('<script id="changyan_mobile_js" charset="utf-8" type="text/javascript" src="https://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=' + appid + '&conf=' + conf + '"><\/script>'); } else { var loadJs=function(d,a){var c=document.getElementsByTagName("head")[0]||document.head||document.documentElement;var b=document.createElement("script");b.setAttribute("type","text/javascript");b.setAttribute("charset","UTF-8");b.setAttribute("src",d);if(typeof a==="function"){if(window.attachEvent){b.onreadystatechange=function(){var e=b.readyState;if(e==="loaded"||e==="complete"){b.onreadystatechange=null;a()}}}else{b.onload=a}}c.appendChild(b)};loadJs("https://changyan.sohu.com/upload/changyan.js",function(){window.changyan.api.config({appid:appid,conf:conf})}); } })(); </script>
</div>



  <footer>
    <div class="footer">
      <div class="f_l">
        <p>All Rights Reserved 版权所有：<a href="http://www.tthcclove.cn">谈同个人博客</a> 备案号：陕ICP备17018883号</p>
      </div>
      <div class="f_r textr">
        <p>157956315</p>
      </div>
    </div>
  </footer>
</div>
<!--百度推送代码-->
<script>
(function(){
    var bp = document.createElement('script');
    var curProtocol = window.location.protocol.split(':')[0];
    if (curProtocol === 'https') {
        bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
    }
    else {
        bp.src = 'http://push.zhanzhang.baidu.com/push.js';
    }
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(bp, s);
})();

//设置登录页面弹出效果  
jQuery(document).ready(function($) {  
$('.nav-login').click(function() {  
$('.login-form-mask').fadeIn(100);  
$('.login-form').slideDown(200);  
})  
$('.login-close').click(function() {  
$('.login-form-mask').fadeOut(100);  
$('.login-form').slideUp(200);  
})  
})  

</script>

</body>
</html>

</html>