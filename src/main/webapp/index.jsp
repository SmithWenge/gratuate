<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp"%>

				<div id="main-text">
					<div id="index">
						<div id="student">
							<p><b>本人查询</b></p>
							<hr />
							<p>
								输入姓名、身份证号码即可查询本人学历。<br /> 主要供毕业生检索个人信息使用。
							</p>
							<form action="${reqBaseURL}/router/search.action">
								<input type="submit" value="查询" >
							</form>
						</div>
						<div id="thirdpart">
							<p>第三方认证</p>
							<hr />
							<p>
								输入姓名、学位证号、发证日期即可认证学生学历。<br /> 主要供用人单位等第三方使用。
							</p>
							<input type="button" value="认证"
								onclick="window.open('<%=basePath%>auth.jsp')">
						</div>
					</div>
					<div id="search"></div>
					<div id="idetity"></div>
					<div id="searchResult"></div>
					<div id="idetityResult"></div>
				</div>

		<%@ include file="/WEB-INF/include/footer.jsp"%>
