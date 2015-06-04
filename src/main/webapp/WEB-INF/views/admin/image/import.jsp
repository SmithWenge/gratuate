<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/include/header.jsp"%>

<div class="col-md-12">
    <div class="panel panel-default" style="margin-top: 2%;">
        <div class="panel-heading">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a>导入图片</a></li>
            </ul>
        </div>
        <div class="panel-body">
            <ul>
                <li>1. 每次可以添加多张图片</li>
                <li>2. 被添加图片的总大小不要超过<b>10M</b></li>
                <li>3. 确定图片的名字为<b>对应学生的生份证号</b>.</li>
                <li>4. 确定图片的格式为<b>jpg</b></li>
                <li>5. 确保没有添加重复的图片</li>
            </ul>
        </div>
        <div class="panel-footer">
            <form class="form-inline" action="${reqBaseURL}/admin/image/import.action" method="post"
                  enctype="multipart/form-data">
                <div class="form-group">
                    <label for="inputImage">添加图片</label>
                    <input type="file" id="inputImage" name="image" multiple>
                    <p class="help-block">请确保添加正确文件</p>
                </div>
                <button type="submit" class="btn btn-default">录入数据</button>
            </form>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/admin/include/footer.jsp"%>
