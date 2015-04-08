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
<title>大连交通大学教务查询系统</title>
<link rel="stylesheet" href="<%=basePath%>resource/new_define.css" />
<script type="text/javascript"
	src="<%=basePath%>resource/jquery-2.1.0.js"></script>

<script>



	//		jQuery(document).ready(function($) {
	//		  $('#clickOne').click(function() {
	//		    alert('OK');
	//		  });
	//		});

	$(document).ready(function() {
		//				$('#blockOne').css('display', 'block');
		//				$('#blockTwo').css('display', 'none');

		$('#clickOne').click(function() {
			$('#blockOne').css('display', 'block');

			$('#blockTwo').css('display', 'none');

		});

		$('#clickTwo').click(function() {
			$('#blockTwo').css('display', 'block');

			$('#blockOne').css('display', 'none');
		});

	});
</script>

<script type="text/javascript">
	    	$( document ).ready(function() {
	    		$("#download").click(function() {
	    			$("#download_form").action = "FileDownload";
			    	$("#download_form").method = "post";
			    	$("#download_form").submit();
			 	});
	    	});
</script>

<style type="text/css">
table {
	border: solid 1px;
	width: auto;
	height: 40px;
	line-height: 30px;
	border-bottom: solid 1px;
	/*border-right: solid 1px;*/
}

table input {
	width: 30px;
	height: 22px;
}

button {
	background: #3581B7;
	width: 140px;
	height: auto;
}

#second_tab th {
	color: #999999;
}

#first_tab {
	border: none;
}

#first_tab td {
	width: 120px;
}

#left-tab {
	display: initial;
	float: left;
	margin-left: 100px;
	margin-right: 100px;
	margin-top: 60px;
}

#left-tab ul a {
	font-size: 24px;
	color: #2A2C2E;
	display: list-item;
}

#right-tab {
	float: left;
}

.active {
	font-weight: 600;
}

#blockTwo {
	display: none;
	float: left;
	margin-top: 20px;
}
</style>

</head>

<body>
	<!--页眉部分-->
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

	<form action="<c:url value='/admin/log.action' />" method="post"
		class="form-horizontal"></form>

	<div id="left-tab">
		<ul>
			<li class="active"><a id="clickOne" href="#">日志查询</a></li>
			<li><a id="clickTwo" href="#">数据维护</a></li>
			<li><a href="#">页面设置</a></li>
			<li><a href="#">统计报表</a></li>
		</ul>
	</div>
	<div id="blockOne">
		<div id="right-tab">
			<!--表格-->
			<table id="first_tab">
				<tr>
					<td colspan="">请选择条件：</td>
					<td colspan=""><select name="years">
							<option value="2013">2013</option>
							<option value="2012">2012</option>
							<option value="2011">2011</option>
							<option value="2010">2010</option>
					</select>年</td>
					<td colspan=""><select name="months"><option
								value="6">6</option></select>月</td>
					<td colspan=""><select><option value="28">28</option></select>日</td>
					<td colspan="2">&nbsp;</td>
					<td><button>查询</button></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="all" />全选</td>
					<td colspan=""><input type="checkbox" name="ck" />管理员登录</td>
					<td colspan="1"><input type="checkbox" name="ck" />用户操作</td>
					<td colspan=""><input type="checkbox" name="ck" />数据更新</td>
					<td colspan=""><input type="checkbox" name="ck" />系统信息</td>
					<td colspan=""><input type="checkbox" name="ck" />其他
					</th>
					<td><button>导出</button></td>
				</tr>
			</table>
			<div class="row">
				<div class="col-md-10" style="margin: 10px">
					<table class="table table-striped">
						<tr>
							<td>时间</td>
							<td>thread</td>
							<td>level</td>
							<td>class</td>
							<td>事件描述</td>
						</tr>
						<c:forEach items="${logs}" var="log">
							<tr>
								<td>${log.createDate }</td>
								<td>${log.thread }</td>
								<td>${log.level }</td>
								<td>${log.clazz }</td>
								<td>${log.message }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<!--right end-->
	</div>
	<div id="blockTwo">
		<h2>数据管理</h2>
		<h3>
		
			<div class="col-sm-2">
				<form id="download_form" action="/FileDownload" method="post">
					操作模板文件 <button type="button" class="btn btn-info" id="download">获取模板</button>
				</form>
			</div>
		</h3>
		<h3>
			执行数据操作
			<button>开始</button>
		</h3>
		<br />
		<h2>照片管理</h2>
		<h3>
			上传照片数据
			<button>开始</button>
		</h3>
		<h3>
			清理无效照片
			<button>开始</button>
		</h3>
	</div>

</body>
</html>




<!--  <tr>
	<td>logId</td>
	<td>createDate</td>
	<td>thread</td>
	<td>level</td>
	<td>class</td>
	<td>message</td>
</tr>
<c:forEach items="${logs}" var="log">
	<tr>
		<td>${log.logId }</td>
		<td>${log.createDate }</td>
		<td>${log.thread }</td>
		<td>${log.level }</td>
		<td>${log.clazz }</td>
		<td>${log.message }</td>
	</tr>
		</c:forEach>	-->