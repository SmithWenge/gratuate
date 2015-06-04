<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/include/header.jsp"%>

<div class="col-md-12">
    <div class="alert alert-success" role="alert" style="margin-top: 2%;"><h3>恭喜!成功录入${rightData}条数据</h3></div>
    <c:if test="${repeatData.size() > 0}">
    <div class="panel panel-default" style="margin-top: 2%;">
        <div class="panel-heading">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a>录入数据中重复数据为</a></li>
            </ul>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <tr>
                    <td>姓名</td>
                    <td>身份证号</td>
                    <td>学号</td>
                    <td>毕业证编号</td>
                    <td>学位证编号</td>
                </tr>
                <c:forEach items="${repeatData}" var="info">
                    <tr>
                        <td>${info.stuName}</td>
                        <td>${info.stuIdentificationNum}</td>
                        <td>${info.stuNumber}</td>
                        <td>${info.stuGraduationCardNum}</td>
                        <td>${info.stuMajorDegreeCertNum}</td>
                    </tr>
                </c:forEach>
            </table>
            <div class="alert alert-danger" role="alert" style="margin-top: 2%;"><h3>重复的数据不需要再次录入.</h3></div>
        </div>
    </div>
    </c:if>
    <c:if test="${errorData.size() > 0}">
    <div class="panel panel-default" style="margin-top: 2%;">
        <div class="panel-heading">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a>录入数据中错误数据为</a></li>
                <li role="presentation" style="float: right;"><a href="${reqBaseURL}/admin/download.action">获取模板</a></li>
            </ul>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <tr>
                    <td>姓名</td>
                    <td>身份证号</td>
                    <td>学号</td>
                    <td>毕业证编号</td>
                    <td>学位证编号</td>
                </tr>
                <c:forEach items="${errorData}" var="info">
                    <tr>
                        <td>${info.stuName}</td>
                        <td>${info.stuIdentificationNum}</td>
                        <td>${info.stuNumber}</td>
                        <td>${info.stuGraduationCardNum}</td>
                        <td>${info.stuMajorDegreeCertNum}</td>
                    </tr>
                </c:forEach>
            </table>
            <div class="alert alert-danger" role="alert" style="margin-top: 2%;"><h3>请获取新的模板,添加发生错误的数据的正确值,重新导入数据.</h3></div>
        </div>
        </c:if>
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
