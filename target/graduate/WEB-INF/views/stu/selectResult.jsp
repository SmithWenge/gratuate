<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>毕业生查询结果页</title>
</head>
<body>
	<form action="<c:url value='/stu/selectResult.action' />" method="post"
		class="form-horizontal">
		<div class="divcss1 divcss2">查询结果</div>
		<h2></h2>
		<h2></h2>
		<h2></h2>
		<h2></h2>
		<h2></h2>

		<table class="table">
			<tr>
				<td></td>
				<td>姓名</td>
				<td>身份证号</td>
				<td>证书编号</td>
				<td>学位类型</td>
				<td>专业</td>
				<td>备注</td>
			</tr>
			<c:forEach items="${stus}" var="stus">
				<tr>
					<td></td>
					<td>${stus.stuName}</td>
					<td>${stus.stuIdentificationNum}</td>
					<td>${stus.stuGraduationCardNum}</td>
					<td>${stus.stuMajorDegree}</td>
					<td>${stus.stuSpecialty}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>