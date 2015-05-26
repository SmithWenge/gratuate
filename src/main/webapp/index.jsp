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
		var imgSrc = "http://" + window.location.host + "/graduate/code.action";
		$("#imgAuthCode").attr("src", imgSrc);
		$("#imgAuthCodeAuth").attr("src", imgSrc);

	}
</script>
<script type="text/javascript">
	function toSelect() {
		window.location.href = "search.jsp?backurl=" + window.location.href;
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
					<div id="index">
						<div id="student">
							<p>本人查询</p>
							<hr />
							<p>
								输入姓名、身份证号码即可查询本人学历。<br /> 主要供毕业生检索个人信息使用。
							</p>
							<input type="button" value="查询"
								onclick="window.open('<%=basePath%>search.jsp')">
						</div>
						<div id="thirdpart">
							<p>第三方认证</p>
							<hr />
							<p>
								输入姓名、学位证号、发证日期即可认证学生学历。<br /> 主要供用人单位等第三方使用。
							</p>
							<input type="button" value="认证"
								onclick="window.open('<%=basePath%>auth.jsp')">
						</div>
					</div>
					<div id="search"></div>
					<div id="idetity"></div>
					<div id="searchResult"></div>
					<div id="idetityResult"></div>
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
