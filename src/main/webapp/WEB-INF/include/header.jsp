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
  <link rel="stylesheet" href="<%=basePath%>resource/bootstrap/css/bootstrap.css" />
  <link rel="stylesheet" href="<%=basePath%>resource/bootstrap/css/bootstrap-select.css" />
  <link rel="stylesheet" href="<%=basePath%>resource/define3.0.css" />
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
<div id="wraper">
  <div id="header"></div>
  <div id="content">
    <div id="side-bar">
      <%--<div id="side-top">--%>
        <%--&lt;%&ndash;<div id="info">&ndash;%&gt;--%>
          <%--&lt;%&ndash;&lt;%&ndash;<p>*注意：</p>&ndash;%&gt;&ndash;%&gt;--%>
          <%--&lt;%&ndash;&lt;%&ndash;<p>学位信息以学校学位部门记载为准</p>&ndash;%&gt;&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
      <%--</div>--%>
      <div id="side-nav">
        <ul class="navY">
          <li><a href="<%=basePath%>index.jsp">首页</a></li>
          <li><a href="${reqBaseURL}/router/search.action">查询</a></li>
          <li><a href="${reqBaseURL}/router/authentication.action">认证</a></li>
          <br />
          <li><a href="${reqBaseURL}/connect.jsp">联系方式</a></li>
          <li><a href="${reqBaseURL}/about.jsp">关于我们</a></li>
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