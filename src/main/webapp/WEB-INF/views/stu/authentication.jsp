<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp"%>

<div id="main-text">
	<div id="idetity">
		<form id="authentication-form" action="${reqBaseURL}/stu/authentication.action" method="post">
			<div class="mainLeft">
				<table>
					<tr>
						<td>学生姓名：</td>
						<td><input type="text" name="stuName" id="stuName" /></td>
					</tr>
					<tr>
						<td>学位证号：</td>
						<td><input type="text" name="stuMajorDegreeCertNum"
							id="stuMajorDegreeCertNum" /></td>
					</tr>
					<tr>
						<td>发证日期：</td>
						<%--<td><input type="date" name="stuPublicationDate" id="stuPublicationDate" placeholder="年/月/日"/></td>--%>
						<td>
							<select name="stuPublicationDate" id="stuPublicationDate"
									class="selectpicker" data-size="5" data-width="200px">
								<c:forEach items="${dates}" var="date">
									<option value="${date}">${date}</option>
								</c:forEach>
							</select>
						</td>
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
						<td colspan="2"><input type="submit" class="btn2"
							value="开始认证"></td>
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
		<div class="mainRight">
			<p>
				填写说明：<br /> 1.<b>姓名</b>需要与待查证书中的姓名书写一致<br />
				2.验证码不区分大小写，看不清点击图片即可更换
			</p>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
