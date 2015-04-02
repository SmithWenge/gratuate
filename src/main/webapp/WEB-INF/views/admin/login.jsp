<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登陆</title>
</head>
<body>
	<form action="<c:url value='/admin/log.action' />"  method="post" class="form-horizontal">
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">username:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="username" name="username" >
			</div>
		</div>
		<div class="form-group">
			<label for="age" class="col-sm-2 control-label">password:</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="password"  name="userpass">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default" value="Sign In">
			</div>
		</div>
	</form>
</body>
</html>