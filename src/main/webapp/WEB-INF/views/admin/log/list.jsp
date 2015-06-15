<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/include/header.jsp"%>

<div class="col-md-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a>查看日志信息</a></li>
                <li role="presentation" style="float: right;"><a href="${reqBaseURL}/log/export.action">下载记录</a></li>
            </ul>
        </div>
        <div class="panel-body">
            <c:if test="${count == 0}">
                <div class="alert alert-success" role="alert">
                    <h3>没有相关的日志信息</h3>
                </div>
            </c:if>
            <c:if test="${count > 0}">
                <div class="alert alert-success" role="alert">
                    <h3>总共有${count}条数据</h3>
                </div>
            </c:if>
            <table class="table table-striped">
                <tr>
                    <%--<td>#</td>--%>
                    <%--<td>IP地址</td>--%>
                    <td>学生姓名</td>
                    <td>学生身份证号</td>
                    <td>学生学位证号</td>
                    <td>发证日期</td>
                    <td>查询/认证</td>
                    <%--<td>时间</td>--%>
                </tr>
                <c:forEach items="${messages}" var="message" varStatus="status">
                    <tr>
                        <%--<td>${status.count}</td>--%>
                        <%--<td>${message.IPAddress}</td>--%>
                        <td>${message.queryStuName}</td>
                        <td>${message.queryStuId}</td>
                        <td>${message.queryStuDegree}</td>
                        <td>${message.queryStuDate}</td>
                        <td>${message.tag}</td>
                        <%--<td>${message.time}</td>--%>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/admin/include/footer.jsp"%>