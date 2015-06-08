<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<div id="main-text">
	<div id="identityResult">
		<table>
			<tr>
				<td><b>根据您输入的内容</b></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td>${stu.stuName}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td rowspan="4"><img src="${reqBaseURL}/router/photo/${stu.stuIdentificationNum}.action"></td>
			</tr>
			<tr>
				<td>学位证号：</td>
				<td>${stu.stuMajorDegreeCertNum}</td>
			</tr>
			<tr>
				<td>发证日期：</td>
				<td>${stu.stuPublicationDate}</td>
			</tr>
			<tr >
				<td><b>查询到以下信息</b></td>
		</table>
		<table>
			<tr>
				<td>性别</td><td>出生日期</td><td>专业</td><td>学位</td>
			</tr>
			<tr>
				<td>${stu.stuGender}</td>
				<td>${stu.stuBrithday}</td>
				<td>${stu.stuSpecialty}</td>
				<td>${stu.stuMajorDegree}</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td colspan=5><small>*注意：最终学位信息以学位部门记载为准，如有疑义，请与我校相关主管部门联系。联系电话：0411-8622XXXX</small></td>
			</tr>
		</table>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
