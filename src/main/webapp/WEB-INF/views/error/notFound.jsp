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
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="<%=basePath%>resource/bootstrap/css/html_reset.css" />
    <style>
        #header {
            width: 100%;
            height: 105px;
            border: solid 1px #FFFFFF;
            clear: all;
        }

        #content {
            padding: 0 10%;
            border: 2px;
            border-style: solid none;
            height: 424px;
            border-color: #44546a;
        }

        #footer {
            text-align: center;
            margin-top: 30px;
            font-size: 14px;
        }

        img {
            float: left;
            margin-top: 8px;
            margin-left: 10%;
            max-width: 308px;
        }

        #header {
            width: 100%;
            height: 105px;
            border: solid 1px #FFFFFF;
            clear: all;
        }

        .nav_right {
            margin: 53px 10.5% 0 0;
        }

        .nav_right li {
            float: right;
            padding-left: 10px;
            font-size: 24px;
        }

        .nav_right li a {
            color: #44546a;
        }
        .error{
            font-size: 36px;
            text-align: center;
            margin: 35px;
        }
        .advice{
            font-size: 24px;
            text-align: center;

        }
    </style>
</head>

<body>
<!-- header -->
<div id="header">
    <img src="<%=basePath%>resource/bootstrap/img/banner-02.png" alt="大连交通大学" />
    <ul class="nav_right">
        <li><a href="${reqBaseURL}/router/search.action">毕业生学位查询与认证系统</a></li>
    </ul>
</div>

<!-- content -->
<div id="content">
    <h1 class="error">4 0 4</h1>
    <h2 class="error">抱歉，您访问的页面不存在</h2>
    <h2 class="advice">请刷新页面或点击<a href="${reqBaseURL}/router/search.action">返回首页</a></h2>
</div>

<%@ include file="/WEB-INF/include/footer.jsp"%>