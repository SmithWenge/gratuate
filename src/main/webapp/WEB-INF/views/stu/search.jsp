<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/headerStu.jsp"%>

<!-- content -->
<div id="content">
	<div class="main_left">
		<h1>毕业生学位查询与认证系统</h1>
		<p>本系统提供我校2005年以后毕业学生的学位查询与认证功能，所有内容以学位管理部门记录为准，如有疑问，请致电0411-84107635或发电子邮件至jwc@djtu.edu.cn询问</p>
	</div>

	<div class="main_right">
		<div class="head_tab">
			<div class="innerHeadTab">
				<h3 id="inquire">查询</h3>
				<a href="${reqBaseURL}/router/authentication.action"><h3 id="auth">验证</h3></a>
			</div>
		</div>
		<!-- inquire -->
		<div id="inquire_box">
			<form id="search-form" name="search-form" class="form-horizontal" action="${reqBaseURL}/stu/search.action" method="post">
				<div class="form-group lineHeight">
					<label for="stuName" class="col-sm-3 control-label" style="padding: 0;font-weight: 100;">学生姓名</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="stuName" name="stuName" placeholder="姓名与待查证书上书写一致">
					</div>
				</div>
				<div class="form-group lineHeight">
					<label for="stuIdentificationNum" class="col-sm-3 control-label" style="padding: 0;font-weight: 100;">身份证号</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="stuIdentificationNum" name="stuIdentificationNum" placeholder="身份证号中的X不区分大小写">
					</div>
				</div>
				<div class="form-group lineHeight">
					<label for="authCode" class="col-sm-3 control-label" style="padding: 0;font-weight: 100;">验证码</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="authCode" name="authCode" placeholder="验证码不区分大小写">
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-3"></div>
					<div class="col-md-9">
						<a id="change" href="#">
							<img id="authCodeImg" src="${reqBaseURL}/captchaImage.action"/>
							<span style="line-height: 40px;"><em> &nbsp;换一张</em></span>
						</a>
					</div>
				</div>
				<div class="form-group lineHeight">
					<div class="col-sm-10 col-sm-offset-2">
						<button type="submit" class="col-sm-10 btn btn-primary" value="开始查询">开始查询</button>
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



					$("#search-form").validate({
						rules : {
							stuName : {
								required : true,
								minlength : 2,
								maxlength : 10
							},
							stuIdentificationNum : {
								required : true,
								idLength : 18
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
								minlength : "您的姓名的字数需要在2到10之间",
								maxlength : "您的姓名的字数需要在2到10之间"
							},
							stuIdentificationNum : {
								required : "请填写您的身份证号",
								idLength : "身份证号长度是18位"
							},
							authCode : {
								required : "请填写验证码",
								remote: "请输入正确的验证码"
							}
						}
					});
				});
			</script>
		</div>

	</div>
</div>

<%@ include file="/WEB-INF/include/footerStu.jsp"%>