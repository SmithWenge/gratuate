<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp"%>

<div id="main-text">
	<div id="searchResult">
		<table>
			<tr>
				<td colspan="2">根据您输入的内容</td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td>${stu.stuName }</td>
			</tr>
			<tr>
				<td>身份证号：</td>
				<td>${stu.stuIdentificationNum }</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2">我们查询到如下信息：</td>
			</tr>
		</table>
		<table>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>证书编号：</td>
				<td>学位类型</td>
				<td>专业</td>
				<td>备注</td>
			</tr>
			<tr>
				<td id="stuGraduationCardNum"></td>
				<td id="stuMajorDegree"></td>
				<td id="stuSpecialty"></td>
				<td>----</td>
			</tr>
			<tr>
				<td>${stu.stuGraduationCardNum}</td>
				<td>${stu.stuMajorDegree}</td>
				<td>${stu.stuSpecialty}</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp</td>
			</tr>
			<tr>
				<td colspan=5><small>*注意：最终学位信息以学位部门记载为准，如有疑义，请与我校相关主管部门联系。联系电话：0411-8622XXXX</small></td>
			</tr>
		</table>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>
