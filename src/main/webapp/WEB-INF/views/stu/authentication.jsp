<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/headerStu.jsp"%>

<!-- content -->
<div id="content">
	<div class="main_left">
		<h1>毕业生学位查询与认证系统</h1>
		<p>本系统提供我校2005年以后毕业学生的学位查询与认证功能，所有内容以学位管理部门记录为准，如有疑问，请致电0411-84107635或发电子邮件至jwc@djtu.edu.cn询问</p>
	</div>

	<!-- 认证登录 -->
	<div class="main_right">
		<div class="head_tab">
			<div class="innerHeadTab">
				<a href="${reqBaseURL}/router/search.action"><h3 id="inquire">查询</h3></a>
				<h3 id="auth">验证</h3>
			</div>
		</div>

		<!-- auth -->
		<div id="auth_box">
			<form id="authentication-form" class="form-horizontal" action="${reqBaseURL}/stu/authentication.action" method="post">
				<div class="form-group lineHeight marginBottom">
					<label for="stuName" class="col-sm-3 control-label" style="padding: 0;font-weight: 100;">学生姓名</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="stuName" id="stuName" placeholder="姓名与待查证书上书写一致">
					</div>
				</div>
				<div class="form-group lineHeight marginBottom">
					<label for="stuMajorDegreeCertNum" class="col-sm-3 control-label" style="padding: 0; font-weight: 100;">学位证号</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="stuMajorDegreeCertNum" name="stuMajorDegreeCertNum">
					</div>
				</div>
				<div class="form-group lineHeight marginBottom">
					<label for="date" class="col-sm-3 control-label" style="padding: 0;font-weight: 100;">发证日期</label>
					<div class="col-sm-8">
						<select name="stuPublicationDate" id="stuPublicationDate" class="form-control" data-size="5" data-width="200px">
							<c:forEach items="${dates}" var="date">
								<option value="${date}">${date}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group lineHeight marginBottom">
					<label for="authCode" class="col-sm-3 control-label" style="padding: 0;font-weight: 100;">验证码</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="authCode" id="authCode" placeholder="验证码不区分大小写">
					</div>
				</div>
				<div class="form-group marginBottom">
					<div class="col-md-3"></div>
					<div class="col-md-9">
						<a id="change" href="#">
							<img id="authCodeImg" src="${reqBaseURL}/captchaImage.action" />
							<span style="line-height: 40px;"><em> &nbsp;换一张</em></span>
						</a>
					</div>
				</div>
				<div class="form-group lineHeight">
					<div class="col-sm-10 col-sm-offset-2">
						<button class="col-sm-10 btn btn-primary" value="开始认证" />开始认证</button>
					</div>
				</div>
			</form>
			<script type="text/javascript">
				$(function() {
					$("#change").on('click', function() {
						$("#authCodeImg").attr("src", "${reqBaseURL}/captchaImage.action?ran=" + new Date() / 100);
					});

					jQuery.validator.addMethod("idLength", function(value, element, param) {
						return this.optional(element) || value.length == param;
					}, $.validator.format("请确认你的身份证号的长度为 {0}"));



					$("#authentication-form").validate({
						rules : {
							stuName : {
								required : true,
								minlength : 2,
								maxlength : 10
							},
							stuMajorDegreeCertNum : {
								required : true,
								idLength : 16
							},
							stuPublicationDate : {
								required : true
							},
							authCode : {
								required : true,
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
							}
						},
						messages : {
							stuName : {
								required : "请输入您的姓名",
								minlength : "姓名在2到10之间",
								maxlength : "姓名在2到10之间"
							},
							stuMajorDegreeCertNum : {
								required : "请填写学位证号",
								idLength : "学位证号是16位"
							},
							stuPublicationDate : {
								required : "请输入发证日期"
							},
							authCode : {
								required : "请填写验证码",
								remote: "请确定验证码正确"
							}
						}
					});
				});
			</script>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/include/footerStu.jsp"%>