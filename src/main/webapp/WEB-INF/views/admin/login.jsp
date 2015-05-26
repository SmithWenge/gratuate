<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<link href="<%=basePath%>resource/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>resource/bootstrap/css/bootstrap-theme.min.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>resource/new_define.css" />
<script type="text/javascript"
	src="<%=basePath%>resource/jquery-2.1.0.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登陆</title>
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
	<h3 style="text-align:center">管理员登陆</h3>

	<form action="<c:url value='/admin/log.action' />" method="post"
		class="form-horizontal">
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">用户名：</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="username"
					name="username">
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">密码：</label>
			<div class="col-sm-9">
				<input type="password" class="form-control" id="password"
					name="userpass">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Sign in</button>
			</div>
		</div>
	</form>
	<div class="footer" style="position:absolute;bottom:0">
		<div class="footerinside">
			<p class="footer-p">版权所有 ©2006 - 2015 大连交通大学 | 辽ICP备 05001355号</p>
			<p class="footer-p">学校地址：大连市沙河口区黄河路794号 邮编：116028
				联系我们：xcbu@djtu.edu.cn</p>
		</div>
	</div>
</body>
</html>