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
<meta charset="utf-8" />
<title>大连交通大学学位查询与认证系统</title>
<link rel="stylesheet" href="<%=basePath%>resource/define3.0.css" />
<script type="text/javascript"
	src="<%=basePath%>resource/jquery-2.1.0.js"></script>
<script src="<%=basePath%>resource/jquery.validate.js"
	type="text/javascript"></script>
<script src="<%=basePath%>resource/jquery.metadata.js"
	type="text/javascript"></script>
<script src="<%=basePath%>resource/messages_cn.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function getNewAuthCode() {
		//document.getElementById("imgAuthCode").src = "http://" + window.location.host + "/graduate/code.action";
		var imgSrc = "http://" + window.location.host + "/graduate/code.action";
		$("#imgAuthCode").attr("src", imgSrc);
		$("#imgAuthCodeAuth").attr("src", imgSrc);

	}
</script>
</head>
<body>
	<div id="wraper">
		<div id="header"></div>
		<div id="content">
			<div id="side-bar">
				<div id="side-top">
					<div id="info">
						<p>*注意：</p>
						<p>学位信息以学校学位部门记载为准</p>
					</div>
				</div>
				<div id="side-nav">
					<ul class="navY">
						<li><a href="<%=basePath%>index.jsp">首页</a></li>
						<li><a href="<%=basePath%>search.jsp" target="_blank">查询</a></li>
						<li><a href="<%=basePath%>auth.jsp" target="_blank">认证</a></li>
						<br />
						<li><a href="#">联系方式</a></li>
						<li><a href="#">关于我们</a></li>
					</ul>
				</div>
			</div>
			<div id="main">
				<div id="main-nav">
					<ul class="navX">
						<li><a href="http://www.djtu.edu.cn" target="_blank">学校首页</a></li>
						<li><a href="#">教务处</a></li>
						<li><a href="#">学科学位办</a></li>
					</ul>
				</div>
				<div id="main-title">
					<p>大连交通大学学位查询与认证系统</p>
					<small>Dalian Jiaotong University Degree Queries and
						Certification System</small>
				</div>
				<div id="main-text">
					<div id="search">
						<form action="<c:url value='stu/searchResult.action' />" method="post">
							<div class="mainLeft">
								<table>
									<tr>
										<td>学生姓名：</td>
										<td><input type="text" name="stuName" id="stuName" /></td>
									</tr>
									<tr>
										<td>身份证号：</td>
										<td><input type="text" name="stuIdentificationNum"
											id="stuIdentificationNum" /></td>
									</tr>
									<tr>
										<td>验证码：</td>
										<td><input style="width: 100px;" type="text"
											name="authCode" id="authCode" /> <a style="color: #3581B7;"
											onclick="getNewAuthCode();"> <img id="imgAuthCode"
												src="<c:url value='/code.action' />" /> <small><sub>看不清，换一张</sub></small>
										</a></td>
									</tr>
									<tr>
										<td colspan="2">
											<input type="submit" class="btn2" value="开始查询">
										</td>
									</tr>
								</table>
							</div>
						</form>
						<div class="mainRight">
							<p>
								填写说明：<br /> 1.“姓名”需要与待查证书中的姓名书写一致；<br /> 2.身份证号中的X不区分大小写；<br />
								3.验证码不区分大小写，看不清点击图片即可更换。
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			<p>版权所有 ©2006 - 2015 大连交通大学 | 辽ICP备 05001355号</p>
			<p>学校地址：大连市沙河口区黄河路794号 邮编：116028 联系我们：xcbu@djtu.edu.cn</p>
		</div>
	</div>
</body>
</html>
