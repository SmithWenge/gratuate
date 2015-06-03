<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/include/header.jsp"%>

<div class="col-md-12">
    <div class="panel panel-default" style="margin-top: 2%;">
        <div class="panel-heading">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a>录入数据中错误数据为</a></li>
                <li role="presentation" style="float: right;"><a href="${reqBaseURL}/admin/download.action">获取模板</a></li>
            </ul>
        </div>
        <div class="panel-body">
            <c:forEach items="${data}" var="info">
                ${info.stuMajorDegreeCertNum}
            </c:forEach>
            <h1>请获取新的模板,添加发生错误的数据的正确值,重新导入数据</h1>
        </div>
        <div class="panel-footer">
            <form class="form-inline" action="${reqBaseURL}/admin/import.action" method="post"
                  enctype="multipart/form-data">
                <div class="form-group">
                    <label for="inputFile">添加文件</label>
                    <input type="file" id="inputFile" name="file">
                    <p class="help-block">请确保添加正确文件</p>
                </div>
                <button type="submit" class="btn btn-default">录入数据</button>
            </form>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/admin/include/footer.jsp"%>
