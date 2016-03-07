<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="reqBaseURL" value="${pageContext.request.contextPath}"/>
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
  <!-- 加载html_reset.css -->
  <link rel="stylesheet" href="<%=basePath%>resource/bootstrap/css/html_reset.css" />
  <!-- 加载bootstrap层叠样式表 -->
  <link href="<%=basePath%>resource/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
  <!-- 加载首页认证样式 -->
    <link rel="stylesheet" href="<%=basePath%>resource/bootstrap/css/inquireResult.css" />
    <link href="<%=basePath%>resource/bootstrap/css/inquireFalse.css" rel="stylesheet"  />
    <link rel="stylesheet" href="<%=basePath%>resource/bootstrap/css/authFalse.css" />
    <link rel="stylesheet" href="<%=basePath%>resource/bootstrap/css/authResult.css" />

  <script type="text/javascript"
          src="<%=basePath%>resource/jquery-2.1.0.js"></script>
  <script src="<%=basePath%>resource/bootstrap/js/bootstrap.js"
          type="text/javascript"></script>
  <script src="<%=basePath%>resource/bootstrap/js/bootstrap-select.js"
          type="text/javascript"></script>
  <script src="<%=basePath%>resource/jquery.validate.js"
          type="text/javascript"></script>
  <script src="<%=basePath%>resource/jquery.metadata.js"
          type="text/javascript"></script>
  <script src="<%=basePath%>resource/messages_cn.js"
          type="text/javascript"></script>
</head>


<body>
<!-- header -->
<div id="header">
  <img src="<%=basePath%>resource/bootstrap/img/banner-02.png" alt="大连交通大学" />
  <ul class="nav_right">
    <li><a href="${reqBaseURL}/router/search.action">毕业生学位查询与认证系统</a></li>
  </ul>
</div>
