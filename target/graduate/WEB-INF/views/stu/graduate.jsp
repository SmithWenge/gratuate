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
<link rel="stylesheet" href="new_define.css" />
<script type="text/javascript"
	src="<%=basePath%>resourse/jquery-2.1.0.js"></script>
</head>
<body>
	<form action="<c:url value='/stu/graduate.action' />" method="post"
		class="form-horizontal">
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
		<div class="content">
			<div id="model1">
				<table>
					<tr>
						<td id="td1-1">
							<p class="headline1">大连交通大学</p>
							<p class="headline1">学位查询与认证系统</p>
							<p class="headline2">Dalian Jiaotong University</p>
							<p class="headline2">Dgree queries and certification system</p>
							<button>查询</button>
							<button>认证</button>
							<p>*注意：“查询”功能主要供毕业生检索个人信息使用</p>
							<p>“认证”功能主要供用人单位等第三方使用</p>
						</td>
						<td>
							<div id="td1-2">
								<img src="bg.jpg" />
							</div>
						</td>
					</tr>
				</table>
			</div>
			<!--学位查询-->
			<div id="model2">
				<div>
					<div class="model-left">
						<p class="tab-title">
							<b>学位查询</b>
						</p>
						<table>
							<tr>
								<td>学生姓名：</td>
								<td><input /></td>
							</tr>
							<tr>
								<td>身份证号：</td>
								<td><input /></td>
							</tr>
							<tr>
								<td>验证码：</td>
								<td><input /></td>
								<td><img src="#" /></td>
								<td><a href="#">看不清，换一张</a></td>
							</tr>
						</table>
					</div>
					<div class="model-right">
						<table>
							<tr>
								<td>填写说明：</td>
							</tr>
							<tr>
								<td>1.“姓名”需要与待查证书中的姓名书写一致；</td>
							</tr>
							<tr>
								<td>2.身份证号中的X不区分大小写；</td>
							</tr>
							<tr>
								<td>3.验证码不区分大小写，看不清点击图片即可更换。</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<!--学位认证-->
			<div id="model2_1">
				<div>
					<div class="model-left">
						<p class="tab-title">
							<b>学位认证</b>
						</p>
						<table>
							<tr>
								<td>学生姓名：</td>
								<td><input /></td>
							</tr>
							<tr>
								<td>学生证号：</td>
								<td><input /></td>
							</tr>
							<tr>
								<td>发证日期：</td>
								<td><input type="date" /></td>
							</tr>
							<tr>
								<td>验证码：</td>
								<td><input /></td>
								<td><img src="#" /></td>
								<td><a href="#">看不清，换一张</a></td>
							</tr>
						</table>
					</div>
					<div class="model-right">
						<table>
							<tr>
								<td>填写说明：</td>
							</tr>
							<tr>
								<td>1.“姓名”需要与待查证书中的姓名书写一致；</td>
							</tr>
							<tr>
								<td>2.验证码不区分大小写，看不清点击图片即可更换。；</td>
							</tr>
						</table>
					</div>
				</div>
			</div>

			<div id="model3">
				<div class="model-left">
					<div>
						<p class="tab-title">
							<b>查询结果</b>
						</p>
						<table>
							<tr>
								<td>根据您输入的内容</td>
							</tr>
							<tr>
								<td>学生姓名：</td>
								<td>喵了个咪</td>
							</tr>
							<tr>
								<td>身份证号：</td>
								<td>210001165432132</td>
							</tr>
							<tr></tr>
							<tr>
								<td>我们查询到如下信息：</td>
							</tr>
						</table>
					</div>
				</div>
			</div>

		</div>
		<div class="footer">
			<div class="footerinside">
				<p class="footer-p">版权所有 ©2006 - 2015 大连交通大学 | 辽ICP备 05001355号</p>
				<p class="footer-p">学校地址：大连市沙河口区黄河路794号 邮编：116028
					联系我们：xcbu@djtu.edu.cn</p>
			</div>
		</div>
	</form>
</body>
</html>
