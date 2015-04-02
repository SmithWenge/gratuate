<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>大连交通大学教务查询系统</title>
<link rel="stylesheet" href="<%=basePath%>resource/new_define.css" />
<script type="text/javascript" src="<%=basePath%>resource/jquery-2.1.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="header">
		<div class="header-container">
			<ul class="ulOne">
				<li><a href="#">首页</a></li>
				<li><a href="#">联系方式</a></li>
				<li><a href="#">关于</a></li>
			</ul>
			<ul class="ulTwo">
				<li><a href="#">学校首页</a></li>
				<li><a href="#">教务处</a></li>
				<li><a href="#">学科学位办</a></li>
			</ul>
		</div>
	</div>
	<h1>认证信息错误 请重试</h1>
</body>
</html>