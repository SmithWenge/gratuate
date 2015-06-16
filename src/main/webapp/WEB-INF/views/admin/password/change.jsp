<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/include/header.jsp"%>

<div class="col-md-12">
	<div class="panel panel-default">
		<div class="panel-heading">更改密码</div>
		<div class="panel-body">
			<form id="login-form" class="form-horizontal" action="${reqBaseURL}/password/change.action" method="post">
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">原密码</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="password" placeholder="请输入原密码" name="password">
					</div>
				</div>
				<div class="form-group">
					<label for="newpassword" class="col-sm-2 control-label">新密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="newpassword" placeholder="请输入新密码" name="newpassword">
					</div>
				</div>
				<div class="form-group">
					<label for="repassword" class="col-sm-2 control-label">再次输入新密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="repassword" placeholder="请再次输入新密码" name="repassword">
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
						<button type="submit" class="btn btn-default">更改密码</button>
					</div>
				</div>
			</form>
			<script type="text/javascript">
				$(function() {
					$("#change").on('click', function() {
						$("#authCodeImg").attr("src", "${reqBaseURL}/captchaImage.action?ran=" + new Date() / 100);
					});

					$("#login-form").validate({
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
							password: {
								required: true
							},
							newpassword: {
								required: true
							},
							repassword: {
								required: true,
								equalTo: "#newpassword"
							}
						},
						messages: {
							authCode: {
								required: "请填写验证码",
								remote: "请输入正确的验证码"
							},
							password: {
								required: "请输入原密码"
							},
							newpassword: {
								required: "请输入新密码"
							},
							repassword: {
								required: "请再次输入新密码",
								equalTo: "请保证两次输入的密码相同"
							}
						}
					});
				});
			</script>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/views/admin/include/footer.jsp"%>