<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>auth</title>
</head>
<body>
	<form action="<c:url value='/stu/authResult.action' />"  method="post" class="form-horizontal">
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">姓名</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="stuName" name="stuName" >
			</div>
		</div>
		<div class="form-group">
			<label for="age" class="col-sm-2 control-label">学位证号</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="stuMajorDegreeCertNum"  name="stuMajorDegreeCertNum">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default" value="auth">
			</div>
		</div>
	</form>
</body>
</html>