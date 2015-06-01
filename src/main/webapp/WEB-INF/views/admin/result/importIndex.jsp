<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/include/header.jsp"%>

<div class="col-md-12">
    <div class="panel panel-default" style="margin-top: 2%;">
        <div class="panel-heading">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a>录入数据</a></li>
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
            </ul>
        </div>
        <div class="panel-footer">
            <form class="form-inline" action="${reqBaseURL}/admin/import.action" method="post"
                  enctype="multipart/form-data">
                <div class="form-group">
                    <label for="inputFile">添加文件</label>
                    <input type="file" id="inputFile">
                    <p class="help-block">请确保添加正确文件</p>
                </div>
                <button type="submit" class="btn btn-default">录入数据</button>
            </form>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/admin/include/footer.jsp"%>
