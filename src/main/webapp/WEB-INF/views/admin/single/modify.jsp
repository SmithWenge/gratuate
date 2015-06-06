<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/include/header.jsp"%>

<div class="col-md-12">
<div class="panel panel-default" style="margin-top: 2%;">
	<div class="panel-heading">
		<ul class="nav nav-pills">
			<li role="presentation" class="active"><a>更改毕业生信息</a></li>
		</ul>
	</div>
	<div class="panel-body">
		<form class="form-horizontal" method="post" action="${reqBaseURL}/admin/single/update.action"
			  enctype="multipart/form-data" id="add-form">
			<input type="hidden" value="${stu.id}" name="id">
			<div class="col-md-12">
				<div class="col-md-8">
					<div class="form-group">
						<label for="stuName" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="stuName" value="${stu.stuName}" name="stuName">
						</div>
					</div>
					<div class="form-group">
						<label for="stuNumber" class="col-sm-2 control-label" readOnly>学号</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="stuNumber" value="${stu.stuNumber}" name="stuNumber">
						</div>
					</div>
					<div class="form-group">
						<label for="stuGender" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-10">
							<select name="stuGender" id="stuGender" class="form-control">
								<option value="男">男</option>
								<option value="女">女</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="stuBrithday" class="col-sm-2 control-label">出生日期</label>
						<div class="col-sm-10">
							<input type="date" class="form-control" id="stuBrithday" value="${stu.stuBrithday}" name="stuBrithday">
						</div>
					</div>
					<div class="form-group">
						<label for="stuEnrollment" class="col-sm-2 control-label">入学时间</label>
						<div class="col-sm-10">
							<input type="date" class="form-control" id="stuEnrollment" value="${stu.stuEnrollment}" name="stuEnrollment">
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<a><img src="${reqBaseURL}/router/photo/${realFileName}.action"></a>
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group">
					<label for="stuGraduation" class="col-sm-2 control-label">毕业时间</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" id="stuGraduation" value="${stu.stuGraduation}" name="stuGraduation">
					</div>
				</div>
				<div class="form-group">
					<label for="stuSpecialty" class="col-sm-2 control-label">专业</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="stuSpecialty" value="${stu.stuSpecialty}" name="stuSpecialty">
					</div>
				</div>
				<div class="form-group">
					<label for="stuGraduationCardNum" class="col-sm-2 control-label">毕业证编号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="stuGraduationCardNum" value="${stu.stuGraduationCardNum}" name="stuGraduationCardNum">
					</div>
				</div>
				<div class="form-group">
					<label for="stuMajorDegreeCertNum" class="col-sm-2 control-label">学位证编号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="stuMajorDegreeCertNum" value="${stu.stuMajorDegreeCertNum}" name="stuMajorDegreeCertNum">
					</div>
				</div>
				<div class="form-group">
					<label for="stuMajorDegree" class="col-sm-2 control-label">学生学位类型</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="stuMajorDegree" value="${stu.stuMajorDegree}" name="stuMajorDegree">
					</div>
				</div>
				<div class="form-group">
					<label for="stuIdentificationNum" class="col-sm-2 control-label">身份证号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="stuIdentificationNum" value="${stu.stuIdentificationNum}" name="stuIdentificationNum">
					</div>
				</div>
				<div class="form-group">
					<label for="stuPublicationDate" class="col-sm-2 control-label">发证日期</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" id="stuPublicationDate" value="${stu.stuPublicationDate}" name="stuPublicationDate">
					</div>
				</div>
				<div class="form-group">
					<label for="file" class="col-sm-2 control-label">上传学生照片</label>
					<div class="col-sm-10">
						<input type="file" id="file" name="file">
						<p class="help-block">选择正确的学生照片.</p>
					</div>
				</div>
				<div class="form-group">
					<label for="authCode" class="col-sm-2 control-label">验证码</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="authCode" placeholder="请输入验证码" name="authCode">
					</div>
				</div>
				<div class="form-group">
					<label for="authCode" class="col-sm-2 control-label"></label>
					<div class="col-sm-10">
						<a id="change">
							<img id="authCodeImg" src="${reqBaseURL}/captchaImage.action" />
							<span style="color: #0f0f0f;">看不清，换一张</span>
						</a>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">更新</button>
					</div>
				</div>
			</div>
		</form>
		<script type="text/javascript">
			$(function() {
				$("#change").on('click', function() {
					$("#authCodeImg").attr("src", "${reqBaseURL}/captchaImage.action?ran=" + new Date() / 100);
				});

				jQuery.validator.addMethod("fieldLength", function(value, element, param) {
					return this.optional(element) || value.length == param;
				}, $.validator.format("请确认填写信息的长度为 {0}"));

				$("#add-form").validate({
					rules : {
						authCode: {
							required: true,
							remote: {
								url : "${reqBaseURL}/router/validateCode.action",
								type : "post",
								dataType : "json",
								data : {
									authCode : function() {
										return $("#authCode").val();
									}
								}
							}
						},
						stuName : {
							required: true,
							minlength : 2,
							maxlength : 10
						},
						stuBrithday: {
							required: true
						},
						stuEnrollment: {
							required: true
						},
						stuGraduation: {
							required: true
						},
						stuSpecialty: {
							required: true
						},
						stuGraduationCardNum: {
							required: true,
							fieldLength: 16
						},
						stuMajorDegreeCertNum: {
							required: true,
							fieldLength: 16
						},
						stuMajorDegree: {
							required: true
						},
						stuIdentificationNum: {
							required: true,
							fieldLength: 18
						},
						stuPublicationDate: {
							required: true
						},
						file: {
							required: true
						}
					},
					messages: {
						authCode: {
							required: "请填写验证码",
							remote: "请输入正确的验证码"
						},
						stuName: {
							required: "请填写学生姓名",
							minlength : "学生姓名的长度应该是2到10",
							maxlength : "学生姓名的长度应该是2到10"
						},
						stuBrithday: {
							required: "请填写学生出生日期"
						},
						stuEnrollment: {
							required: "请填写学生的入学日期"
						},
						stuGraduation: {
							required: "请填写学生的毕业时间"
						},
						stuSpecialty: {
							required: "请填写学生的专业"
						},
						stuGraduationCardNum: {
							required: "请填写学生的毕业证号",
							fieldLength: "请确保学生毕业证号的长度为16"
						},
						stuMajorDegreeCertNum: {
							required: "请填写学生学位证编号",
							fieldLength: "请确保学生学位证编号的长度为16"
						},
						stuMajorDegree: {
							required: "请填写学生学位证类型"
						},
						stuIdentificationNum: {
							required: "请填写学生的身份证号",
							fieldLength: "请确保学生身份证号的长度为18"
						},
						stuPublicationDate: {
							required: "请填写发证日期"
						},
						file: {
							required: "请选择学生照片"
						}
					}
				});
			});
		</script>
	</div>
</div>
</div>

<%@include file="/WEB-INF/views/admin/include/footer.jsp"%>