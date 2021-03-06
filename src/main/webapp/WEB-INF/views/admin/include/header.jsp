<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="reqBaseURL" value="${pageContext.request.contextPath}"/>

<html>
<head>
  <title>管理员登陆</title>
  <link rel="stylesheet" href="${reqBaseURL}/resource/bootstrap/css/bootstrap.css" />

  <script type="text/javascript" src="${reqBaseURL}/resource/jquery-2.1.0.js"></script>
  <script src="${reqBaseURL}/resource/bootstrap/js/bootstrap.js" type="text/javascript"></script>
  <script src="${reqBaseURL}/resource/jquery.validate.js" type="text/javascript"></script>

  <style type="text/css">
    img {
      max-width:220px;
      _width:expression(this.width > 22 ? "220px" : this.width);
    }
  </style>
</head>
<body>
<div class="col-md-2"></div>
<div class="col-md-8">
  <div style="margin-top: 2%;" class="col-md-12">
    <div id="header">
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header">
            <a class="navbar-brand" href="${reqBaseURL}/router/admin.action">管理首页</a>
          </div>

          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
              <li><a href="${reqBaseURL}/router/admin.action">导入数据</a></li>
              <li><a href="${reqBaseURL}/router/image.action">导入照片</a></li>
              <li><a href="${reqBaseURL}/router/single.action">数据维护</a></li>
              <%--<li><a href="${reqBaseURL}/router/log/index.action">日志文件</a></li>--%>
              <li><a href="${reqBaseURL}/log/list.action">日志信息</a></li>
              <li><a href="${reqBaseURL}/router/password.action">更改密码</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a>管理员: ${sessionScope.adminLogin.username}</a></li>
              <li><a href="${reqBaseURL}/admin/logout.action">退出</a></li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
  </div>