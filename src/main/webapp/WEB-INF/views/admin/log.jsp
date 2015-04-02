<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>log</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="<%=basePath %>resources/jquery-2.1.0.js"></script>
<script type="text/javascript"
	src="<%=basePath %>resources/bootstrap/js/bootstrap.min.js"></script>
<link href="<%=basePath %>resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath %>resources/bootstrap/css/bootstrap-theme.min.css"
	rel="stylesheet" type="text/css" />

<script type="text/javascript">
	
</script>
</head>

<body>
	<form action="<c:url value='/admin/log.action' />" method="post"
		class="form-horizontal">
		<div class="divcss1 divcss2">日志查询</div>
		<h2></h2>
		<h2></h2>
		<h2></h2>
		<h2></h2>
		<h2></h2>
	</form>
	<form>
	<div class="row">
		<div class="col-md-10" style="margin: 10px">
			<table class="table table-striped">
				<tr>
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
				</c:forEach>
			</table>
		</div>
	</div>
	</form>
</body>
</html>