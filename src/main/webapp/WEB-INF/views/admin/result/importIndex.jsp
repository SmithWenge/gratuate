<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/include/header.jsp"%>

<div class="col-md-12">
    <c:if test="${recent} !=null && ${total} != null">
        <div class="alert alert-success" role="alert" style="margin-top: 2%;">
            <h3>上次登录时间为: ${recent}</h3>
            <h3>总共的数据条数为: ${total}</h3>
        </div>
    </c:if>
    <div class="panel panel-default" style="margin-top: 2%;">
        <div class="panel-heading">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a>导入数据</a></li>
                <li role="presentation" style="float: right;"><a href="${reqBaseURL}/admin/download.action">获取模板</a></li>
            </ul>
        </div>
        <div class="panel-body">
            <ul>
                <li>1. 首先下载录入数据的模板</li>
                <li>2. 按着模板中的需要的字段<b>替换</b>(添加相关数据)</li>
                <li>3. 确定文件中数据的正确性,<b>是否有不合法数据,例如空值</b>,确定数据的<b>对应关系</b>正确.</li>
                <li>4. 确定文件文件大小<b>不能大于10M</b></li>
                <li>5. 确保每次录入的条目<b>不能大于500</b>条</li>
                <li>6. 请确保<b>*标识</b>的字段填写</li>
                <li>7. 请确保时间的格式为<b>YYYY-MM-DD</b></li>
                <li>8. 请确保填写数据的边界正确,<b>即不要存在没有数据的列</b></li>
            </ul>
        </div>
        <div class="panel-footer">
            <form class="form-inline" action="${reqBaseURL}/admin/import.action" method="post"
                  enctype="multipart/form-data">
                <div class="form-group">
                    <label for="inputFile">添加数据文件</label>
                    <input type="file" id="inputFile" name="file">
                    <p class="help-block">请确保添加正确文件</p>
                </div>
                <button type="submit" class="btn btn-default">导入数据</button>
            </form>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/admin/include/footer.jsp"%>
