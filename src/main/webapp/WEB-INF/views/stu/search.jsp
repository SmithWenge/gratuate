<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="reqBaseURL" value="${pageContext.request.contextPath}"/>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>大连交通大学学位查询与认证系统</title>
	<!-- 加载html_reset.css -->
	<link rel="stylesheet" href="<%=basePath%>resource/bootstrap/css/html_reset.css" />
	<!-- 加载bootstrap层叠样式表 -->
	<link href="<%=basePath%>resource/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<!-- 加载首页认证样式 -->
	<link rel="stylesheet" href="<%=basePath%>resource/bootstrap/css/inquire.css" />

	<script type="text/javascript"
			src="<%=basePath%>resource/jquery-2.1.0.js"></script>
	<script src="<%=basePath%>resource/bootstrap/js/bootstrap.js"
			type="text/javascript"></script>
	<script src="<%=basePath%>resource/bootstrap/js/bootstrap-select.js"
			type="text/javascript"></script>
	<script src="<%=basePath%>resource/jquery.validate.js"
			type="text/javascript"></script>
	<script src="<%=basePath%>resource/jquery.metadata.js"
			type="text/javascript"></script>
	<script src="<%=basePath%>resource/messages_cn.js"
			type="text/javascript"></script>
</head>


<body>
<!-- header -->
<div id="header">
	<img src="<%=basePath%>resource/bootstrap/img/banner-02.png" alt="大连交通大学" />
	<ul class="nav_right">
		<li><a href="#">学位办公室</a></li>
		<li><a href="#">教务处</a></li>
		<li>快速访问：</li>
	</ul>
</div>

<!-- content -->
<div id="content">
	<div class="main_left">
		<h1>毕业生学位查询与认证系统</h1>
		<p>本系统提供我校2005年以后毕业学生的学位查询与认证功能，所有内容以学位管理部门记录为准，如有疑问，请致电0411-84107635或发电子邮件至jwc@djtu.edu.cn询问</p>
	</div>

	<div class="main_right">
		<div class="head_tab">
			<div class="innerHeadTab">
				<h3 id="inquire">查询</h3>
				<a href="${reqBaseURL}/router/authentication.action"><h3 id="auth">验证</h3></a>
			</div>
		</div>
		<!-- inquire -->
		<div id="inquire_box">
			<form id="search-form" name="search-form" class="form-horizontal" action="${reqBaseURL}/stu/search.action" method="post">
				<div class="form-group lineHeight">
					<label for="stuName" class="col-sm-3 control-label" style="padding: 0;font-weight: 100;">学生姓名</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="stuName" name="stuName" placeholder="姓名与待查证书上书写一致">
					</div>
				</div>
				<div class="form-group lineHeight">
					<label for="stuIdentificationNum" class="col-sm-3 control-label" style="padding: 0;font-weight: 100;">身份证号</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="stuIdentificationNum" name="stuIdentificationNum" placeholder="身份证号中的X不区分大小写">
					</div>
				</div>
				<div class="form-group lineHeight">
					<label for="authCode" class="col-sm-3 control-label" style="padding: 0;font-weight: 100;">验证码</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="authCode" name="authCode" placeholder="验证码不区分大小写">
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-3"></div>
					<div class="col-md-9">
						<a id="change" href="#">
							<img id="authCodeImg" src="${reqBaseURL}/captchaImage.action"/>
							<span style="line-height: 40px;"><em> &nbsp;换一张</em></span>
						</a>
					</div>
				</div>
				<div class="form-group lineHeight">
					<div class="col-sm-10 col-sm-offset-2">
						<button type="submit" class="col-sm-10 btn btn-primary" value="开始查询">开始查询</button>
					</div>
				</div>
			</form>
			<script type="text/javascript">
				$(function() {
					$("#change").on('click', function() {
						$("#authCodeImg").attr("src", "${reqBaseURL}/captchaImage.action?ran=" + new Date() / 100);
					});

					jQuery.validator.addMethod("idLength", function(value, element, param) {
						return this.optional(element) || value.length == param;
					}, $.validator.format("请确认你的身份证号的长度为 {0}"));



					$("#search-form").validate({
						rules : {
							stuName : {
								required : true,
								minlength : 2,
								maxlength : 10
							},
							stuIdentificationNum : {
								required : true,
								idLength : 18
							},
							authCode : {
								required : true,
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
						messages : {
							stuName : {
								required : "请输入您的姓名",
								minlength : "您的姓名的字数需要在2到10之间",
								maxlength : "您的姓名的字数需要在2到10之间"
							},
							stuIdentificationNum : {
								required : "请填写您的身份证号",
								idLength : "身份证号长度是18位"
							},
							authCode : {
								required : "请填写验证码",
								remote: "请输入正确的验证码"
							}
						}
					});
				});
			</script>
		</div>

	</div>
</div>

<!--footer -->
<div id="footer">
	<p>学校地址：大连市沙河口区黄河路794号　邮编：116028 　联系我们：jwc@djtu.edu.cn </p>
	<p>版权所有 ©2006 - 2015 大连交通大学 　辽ICP备05001355号</p>
</div>
</body>

</html>
