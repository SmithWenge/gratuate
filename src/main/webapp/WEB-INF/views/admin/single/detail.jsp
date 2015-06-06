<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/include/header.jsp"%>

<div class="col-md-12">
<div class="panel panel-default" style="margin-top: 2%;">
	<div class="panel-heading">
		<ul class="nav nav-pills">
			<li role="presentation" class="active"><a>毕业生详细信息</a></li>
			<li role="presentation" style="float: right;"><a href="${reqBaseURL}/admin/single/queryById/${stu.id}.action">更新毕业生信息</a></li>
			<li role="presentation" style="float: right;"><a href="${reqBaseURL}/admin/single/delete.action?id" + ${stu.id}>删除毕业生</a></li>
		</ul>
	</div>
	<div class="panel-body">
		<div class="col-md-12">
			<div class="col-md-8">
				<div class="form-group">
					<label class="col-sm-4 control-label">姓名</label>
					<div class="col-sm-8">
						<p class="form-control-static">${stu.stuName}</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">学号</label>
					<div class="col-sm-8">
						<p class="form-control-static">${stu.stuNumber}</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">性别</label>
					<div class="col-sm-8">
						<p class="form-control-static">${stu.stuGender}</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">出生日期</label>
					<div class="col-sm-8">
						<p class="form-control-static">${stu.stuBrithday}</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">入学时间</label>
					<div class="col-sm-8">
						<p class="form-control-static">${stu.stuEnrollment}</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<a><img src="${reqBaseURL}/router/photo/${realFileName}.action"></a>
			</div>
		</div>
		<div class="col-md-12">
			<div class="form-group">
				<label class="col-sm-4 control-label">毕业时间</label>
				<div class="col-sm-8">
					<p class="form-control-static">${stu.stuGraduation}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">专业</label>
				<div class="col-sm-8">
					<p class="form-control-static">${stu.stuSpecialty}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">毕业证编号</label>
				<div class="col-sm-8">
					<p class="form-control-static">${stu.stuGraduationCardNum}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">学位证编号</label>
				<div class="col-sm-8">
					<p class="form-control-static">${stu.stuMajorDegreeCertNum}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">学生学位类型</label>
				<div class="col-sm-8">
					<p class="form-control-static">${stu.stuMajorDegree}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">身份证号</label>
				<div class="col-sm-8">
					<p class="form-control-static">${stu.stuIdentificationNum}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">发证日期</label>
				<div class="col-sm-8">
					<p class="form-control-static">${stu.stuPublicationDate}</p>
				</div>
			</div>
		</div>
	</div>
</div>
</div>

<%@include file="/WEB-INF/views/admin/include/footer.jsp"%>
