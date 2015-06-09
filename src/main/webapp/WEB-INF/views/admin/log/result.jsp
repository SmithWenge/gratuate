<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/include/header.jsp"%>

<div class="col-md-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a>查看日志文件</a></li>
                <li role="presentation" style="float: right;"><a href="${reqBaseURL}/admin/log/all.action">查看所有日志文件</a></li>
            </ul>
        </div>
        <div class="panel-body">
            <c:if test="${logs.size() == 0}">
                <div class="alert alert-success" role="alert">
                    <h3>没有对应日期的日志</h3>
                </div>
            </c:if>
            <table class="table table-striped">
                <tr>
                    <td>#</td>
                    <td>日志文件名</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${logs}" var="log" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${log}</td>
                        <td>
                            <ul class="nav nav-pills">
                                <%--<li role="presentation">--%>
                                    <%--<a href="${reqBaseURL}/admin/log/delete.action?log=${log}">--%>
                                        <%--<span class="glyphicon glyphicon-remove" aria-hidden="true">删除</span>--%>
                                    <%--</a>--%>
                                <%--</li>--%>
                                <li role="presentation" class="active">
                                    <a href="${reqBaseURL}/admin/log/download.action?log=${log}">
                                        <span class="glyphicon glyphicon-download-alt">下载</span>
                                    </a>
                                </li>
                            </ul>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/admin/include/footer.jsp"%>