<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp"%>

<div id="main-text">
	<div id="index">
		<div id="student">
			<p><b>查询</b></p>
			<hr />
			<p>
				输入<b>姓名</b>、<b>身份证号码</b>即可查询本人学历。<br /> 主要供毕业生检索个人信息使用。
			</p>
			<form action="${reqBaseURL}/router/search.action">
				<input class="btn_sub" type="submit" value="查询" >
			</form>
		</div>
		<div id="thirdpart">
			<p><b>认证</b></p>
			<hr />
			<p>
				输入<b>姓名</b>、<b>学位证号</b>、<b>发证日期</b>即可认证学生学历。<br /> 主要供用人单位等第三方使用。
			</p>
			<form action="${reqBaseURL}/router/authentication.action">
				<input class="btn_sub" type="submit" value="认证" />
			</form>
		</div>
	</div>
	<div id="search"></div>
	<div id="idetity"></div>
	<div id="searchResult"></div>
	<div id="idetityResult"></div>
	<div id="connect"></div>
	<div id="about"></div>
	<div id="error"></div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp"%>
