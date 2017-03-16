<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="${pageContext.request.contextPath}/servlet/RegServlet" method="post">
  		用户名：<input type="text" name="name" value="${uf.name }">${uf.msg.name } ${error }<br>
    	密码：<input type="password" name="password">${uf.msg.password }<br>
    	确认密码：<input type="password" name="repassword">${uf.msg.repassword }<br>
    	邮箱：<input type="text" name="email" value="${uf.email }">${uf.msg.email }<br>
    	生日：<input type="text" name="birthday" value="${uf.birthday }">${uf.msg.birthday }<br>
    	<input type="submit" value="注册">
  </form>
    	
  </body>
</html>
