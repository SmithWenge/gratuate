<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp"%>

<div id="main-text">
	<div id="searchResult">
		<table>
			<tr>
				<td colspan="2"><b>根据您输入的内容</b></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td>${stuName }</td>
			</tr>
			<tr>
				<td>身份证号：</td>
				<td>${stuNameIdNum }</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2"><b>我们查询到如下信息：</b></td>
			</tr>
		</table>
		<table>
			<tr>
				<td>证书编号：</td>
				<td>学位类型</td>
				<td>专业</td>
			</tr>
			<c:forEach items="${stus}" var="stu">
				<tr>
					<td id="stuGraduationCardNum">${stu.stuMajorDegreeCertNum}</td>
					<td id="stuMajorDegree">${stu.stuMajorDegree}</td>
					<td id="stuSpecialty">${stu.stuSpecialty}</td>
				</tr>

			</c:forEach>
			<tr><td>&nbsp;</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td colspan=5><small>*注意：最终学位信息以学位部门记载为准，如有疑义，请与我校相关主管部门联系。联系电话：0411-8622XXXX</small></td>
			</tr>
		</table>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
