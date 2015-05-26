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
					<div id="searchResult">
						<table>
							<tr>
								<td colspan="2">根据您输入的内容</td>
							</tr>
							<tr>
								<td>姓名：</td>
								<td>${stu.stuName }</td>
							</tr>
							<tr>
								<td>身份证号：</td>
								<td>${stu.stuIdentificationNum }</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2">我们查询到如下信息：</td>
							</tr>
						</table>
						<table>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>证书编号：</td>
								<td>学位类型</td>
								<td>专业</td>
								<td>备注</td>
							</tr>
							<tr>
								<td id="stuGraduationCardNum"></td>
								<td id="stuMajorDegree"></td>
								<td id="stuSpecialty"></td>
								<td>----</td>
							</tr>
							<tr>
								<td>${stu.stuGraduationCardNum}</td>
								<td>${stu.stuMajorDegree}</td>
								<td>${stu.stuSpecialty}</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>&nbsp</td>
							</tr>
							<tr>
								<td colspan=5><small>*注意：最终学位信息以学位部门记载为准，如有疑义，请与我校相关主管部门联系。联系电话：0411-8622XXXX</small></td>
							</tr>
						</table>
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
