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
	/* function fileDown() {
		var fd = "http://" + window.location.host + "/graduate/admin/fileDown.action";
		$("#fileDown").attr("src", fd); */
	function fileDown() {
		window.location = "/graduate/admin/fileDown.action";
	}
</script>
<script type="text/javascript">
	function nextPage() {
		var num = parseInt($("#pageNum").val()) + 1;
		$.ajax({
			url : "page.action?page=" + num,
			type : "get",
			dataType : "text",
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				var real = JSON.parse(result);
				$("#pageNum").val(real.page.number);
				$("#firstBlock").hide();
				$("#secondBlock").show();

				var cit = $("#secondBlock");
				if (cit.size() > 0) {
					cit.find("tr:not(:first)").remove();
				}

				var trList = "";
				$("#secondBlock").append(trList);
				$.each(real.page.content, function(i, item) {
					trList += "<tr id='add'><td>" + item.createDate
							+ "</td><td>" + item.thread + "</td><td>"
							+ item.level + "</td><td>" + item.message
							+ "</td></tr>";
				});
				$("#secondBlock").append(trList);
				console.log(real);
				/* console.log(trList); */
			}
		});
	}
</script>
<script type="text/javascript">
	function lastPage() {
		var num = parseInt($("#pageNum").val()) - 1;
		$.ajax({
			url : "page.action?page=" + num,
			type : "get",
			dataType : "text",
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				var real = JSON.parse(result);
				$("#pageNum").val(real.page.number);
				$("#firstBlock").hide();
				$("#secondBlock").show();

				var cit = $("#secondBlock");
				if (cit.size() > 0) {
					cit.find("tr:not(:first)").remove();
				}

				var trList = "";
				$.each(real.page.content, function(i, item) {
					trList += "<tr><td>" + item.createDate + "</td><td>"
							+ item.thread + "</td><td>" + item.level
							+ "</td><td>" + item.message + "</td></tr>";
				});
				$("#secondBlock").append(trList);
				console.log(real);
				console.log(trList);
			}
		});
	}
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
					<td><button>导出</button></td>
				</tr>
			</table>
			<div class="row">
				<div class="col-md-10" style="margin: 10px">
					<table border="1" class="table table-striped" id="firstBlock">
						<tr>
							<th>时间</th>
							<th colspan="">事件类别</th>
							<th colspan="">操作标识</th>
							<th colspan="">事件描述</th>
							<th colspan="">事件IP</th>
							<th>备注</th>
						</tr>
						<c:forEach items="${log}" var="log">
							<tr>
								<td>${log.createDate }</td>
								<td>${log.thread }</td>
								<td>${log.level }</td>
								<td>${log.clazz }</td>
								<td>${log.message }</td>
							</tr>
						</c:forEach>
					</table>
					<table border="1"  class="table table-striped" style="display: none;"
						id="secondBlock">
						<tr>
							<th>时间</th>
							<th colspan="">事件类别</th>
							<th colspan="">操作标识</th>
							<th colspan="">事件描述</th>
							<th colspan="">事件IP</th>
							<th>备注</th>
						</tr>
					</table>
				</div>



				<a onclick="lastPage();" style="color: black">上一页</a> <input
					type="hidden" value="0" id="pageNum"> <a>当前第页</a> <a
					onclick="nextPage();" style="color: black">下一页</a> <input
					type="hidden" value="0" id="pageNum">
			</div>
		</div>
		<!--right end-->
	</div>
	<div id="blockTwo">
		<h2>数据管理</h2>
		<div class="col-sm-5">
			<form action="/graduate/admin/fileDown.action" method="post">
				<button type="submit" class="btn btn-info">获取模板</button>
			</form>
		</div>
		<div class="col-sm-5">
			<!-- 上传数据文件 -->
			<form role="form" action="/graduate/admin/fileUp.action"
				method="post" enctype="multipart/form-data">

				<div class="form-group">
					<input type="file" id="exampleInputFile" name="dataFile">
				</div>
				<button type="submit" class="btn btn-default">导入数据</button>

			</form>
		</div>
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
	<div class="footer" style="position:absolute;bottom:0">
		<div class="footerinside">
			<p class="footer-p">版权所有 ©2006 - 2015 大连交通大学 | 辽ICP备 05001355号</p>
			<p class="footer-p">学校地址：大连市沙河口区黄河路794号 邮编：116028
				联系我们：xcbu@djtu.edu.cn</p>
		</div>
	</div>

</body>
</html>