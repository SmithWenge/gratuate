<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="reqBaseURL" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>管理员登陆</title>
	<link rel="stylesheet" href="${reqBaseURL}/resource/bootstrap/css/bootstrap.css" />

	<script type="text/javascript" src="${reqBaseURL}/resource/jquery-2.1.0.js"></script>
	<script src="${reqBaseURL}/resource/bootstrap/js/bootstrap.js" type="text/javascript"></script>
	<script src="${reqBaseURL}/resource/jquery.validate.js" type="text/javascript"></script>
</head>
<body>
<div class="col-md-2"></div>
<div class="col-md-8">
	<div style="margin-top: 2%;" class="col-md-12">
		<div id="header">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<a class="navbar-brand" href="#">管理首页</a>
					</div>

					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="#">倒入新数据</a></li>
							<li><a href="#">查看日志</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">登陆</div>
			<div class="panel-body">
				<form id="login-form" class="form-horizontal" action="${reqBaseURL}/admin/login.action" method="post">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="username" placeholder="请输入用户名" name="username">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="password" placeholder="请输入密码" name="password">
						</div>
					</div>
					<div class="form-group">
						<label for="authCode" class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="authCode" placeholder="请输入密码" name="authCode">
						</div>
					</div>
					<div class="form-group">
						<label for="authCode" class="col-sm-2 control-label"></label>
						<div class="col-sm-10">
							<a id="change">
								<img id="authCodeImg" src="${reqBaseURL}/captchaImage.action" />
								<span style="color: #0f0f0f;">看不清，换一张</span>
							</a>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">登陆</button>
						</div>
					</div>
				</form>
				<script type="text/javascript">
					$(function() {
						$("#change").on('click', function() {
							$("#authCodeImg").attr("src", "${reqBaseURL}/captchaImage.action?ran=" + new Date() / 100);
						});

						$("#login-form").validate({
							rules : {
								authCode: {
									required: true,
									remote: {
										url : "${reqBaseURL}/router/validateCode.action",
										type : "post",
										dataType : "json",
										data : {
											authCode : function() {
												return $("#authCode").val();
											}
										}
									}
								}
							},
							messages: {
								authCode: {
									required: "请填写验证码",
									remote: "请输入正确的验证码"
								}
							}
						});
					});
				</script>
			</div>
		</div>
	</div>

<%@include file="/WEB-INF/views/admin/include/footer.jsp"%>