<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/include/header.jsp"%>

<div class="col-md-12">
	<c:if test="${waning} !=null">
		<div class="alert alert-warning" role="alert"><h3>${warning}</h3></div>
	</c:if>
<div class="panel panel-default">
	<div class="panel-heading">
		<ul class="nav nav-pills">
			<li role="presentation" class="active"><a>查询毕业生</a></li>
			<li role="presentation" style="float: right;"><a href="${reqBaseURL}/router/single/add.action">添加毕业生</a></li>
		</ul>
	</div>
	<div class="panel-body">
		<form class="form-horizontal" action="${reqBaseURL}/admin/single/query.action" method="post">
			<div class="form-group">
				<label for="stuNumber" class="col-sm-2 control-label">学号</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="stuNumber" placeholder="1234567890" name="stuNumber">
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
					<button type="submit" class="btn btn-default">查询毕业生</button>
				</div>
			</div>
		</form>
	</div>
</div>
</div>

<%@include file="/WEB-INF/views/admin/include/footer.jsp"%>
