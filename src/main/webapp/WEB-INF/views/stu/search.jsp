<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp"%>

<div id="main-text">
	<div id="search">
		<form id="search-form" action="${reqBaseURL}/stu/search.action" method="post">
			<div class="mainLeft">
				<table>
					<tr>
						<td>学生姓名：</td>
						<td><input type="text" name="stuName" id="stuName" /></td>
					</tr>
					<tr>
						<td>身份证号：</td>
						<td><input type="text" name="stuIdentificationNum"
							id="stuIdentificationNum" /></td>
					</tr>
					<tr>
						<td>验证码：</td>
						<td>
							<input type="text" name="authCode" id="authCode" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<a id="change">
								<img id="authCodeImg" src="${reqBaseURL}/captchaImage.action" />
								<span style="color: #0f0f0f;">看不清，换一张</span>
							</a>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" class="btn2" value="开始查询">
						</td>
					</tr>
				</table>
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
							idLength : "您的身份证号长度应该是18位"
						},
						authCode : {
							required : "请填写验证码",
							remote: "请输入正确的验证码"
						}
					}
				});
			});
		</script>
		<div class="mainRight">
			<p>
				填写说明：<br /> 1.“姓名”需要与待查证书中的姓名书写一致；<br /> 2.身份证号中的X不区分大小写；<br />
				3.验证码不区分大小写，看不清点击图片即可更换。
			</p>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp"%>
