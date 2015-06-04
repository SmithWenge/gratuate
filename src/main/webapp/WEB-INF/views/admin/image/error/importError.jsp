<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/include/header.jsp"%>

<div class="col-md-12">
    <div class="alert alert-success" role="alert" style="margin-top: 2%;"><h3>恭喜!成功导入${rightImages}张图片</h3></div>
    <c:if test="${repeatImages.size() > 0}">
    <div class="panel panel-default" style="margin-top: 2%;">
        <div class="panel-heading">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a>倒入图片中中重复的为</a></li>
            </ul>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <tr>
                    <td>#</td>
                    <td>图片名称</td>
                </tr>
                <c:forEach items="${repeatImages}" var="repeatImage" varStatus="count">
                    <tr>
                        <td>${count.count}</td>
                        <td>${repeatImage}</td>
                    </tr>
                </c:forEach>
            </table>
            <div class="alert alert-danger" role="alert" style="margin-top: 2%;"><h3>重复的图片不需要再次导入.</h3></div>
        </div>
    </div>
    </c:if>
    <c:if test="${errorImages.size() > 0}">
    <div class="panel panel-default" style="margin-top: 2%;">
        <div class="panel-heading">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a>导入图片错误的为</a></li>
            </ul>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <tr>
                    <td>#</td>
                    <td>图片名称</td>
                </tr>
                <c:forEach items="${errorImages}" var="errorImage" varStatus="count">
                    <tr>
                        <td>${count.count}</td>
                        <td>${errorImage}</td>
                    </tr>
                </c:forEach>
            </table>
            <div class="alert alert-danger" role="alert" style="margin-top: 2%;"><h3>请更改图片的信息,重新导入错误的图片.</h3></div>
        </div>
        </c:if>
        <div class="panel-footer">
            <form class="form-inline" action="${reqBaseURL}/admin/image/import.action" method="post"
                  enctype="multipart/form-data">
                <div class="form-group">
                    <label for="inputFile">添加图片</label>
                    <input type="file" id="inputFile" name="file">
                    <p class="help-block">请确保添加正确文件</p>
                </div>
                <button type="submit" class="btn btn-default">录入数据</button>
            </form>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/admin/include/footer.jsp"%>
