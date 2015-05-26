<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>大连交通大学教务查询系统</title>
<link rel="stylesheet" href="<%=basePath%>resource/new_define.css" />
<script type="text/javascript" src="<%=basePath%>resource/jquery-2.1.0.js"></script>
<script>
/* 	jQuery(document).ready(function($){
		$('#search').click(function(){
			alert('ok');
		});
	}); */
	$(document).ready(function() {
		// 设置查询,验证块隐藏
		$('#search-form1').css('display', 'none');
		$('#search-form2').css('display', 'none');

		//  点击显示隐藏查询
		$('#search').click(function() {
			$('#search-form2').css('display', 'none');
			$('#feedback2').css('display', 'none');

			$('#search-form1').css('display', 'block');
		});

		// 点击显示认证内容
		$('#identity').click(function() {
			$('#search-form1').css('display', 'none');
			$('#feedback1').css('display', 'none');

			$('#search-form2').css('display', 'block');
			//					$('#templateDate').val('2008-07-01');
		});

		//查看查询结果
		$('#confirm').click(function() {
			$('#feedback1').css('display', 'block');

			$('#feedback2').css('display', 'none');
		});
		//查看认证结果
		$('#confirm2').click(function() {
			$('#feedback2').css('display', 'block');

			$('#feedback1').css('display', 'none');
		});
	});
</script>
<script type="text/javascript">
	function degreeQuery() {
		var data = {};
		data['stuName'] = $('#stuName').val();
		data['stuIdentificationNum'] = $('#stuIdentificationNum').val();
		data['authCode'] = $('#authCode').val();

		console.log(JSON.stringify(data));
		$.ajax({
			type : "POST",
			url : "/graduate/stu/select.action",
			data : JSON.stringify(data),
			dataType : "text",
			contentType : "application/json; charset=utf-8",
			success : function(responseText) {
				var result = JSON.parse(responseText);
				var stuName = result.stu.stuName;
				var stuIdentificationNum = result.stu.stuIdentificationNum;
				
				if (stuName) {
					$('#resultStuName').html(result.stu.stuName);
					$('#resultStuIdentificationNum').html(
							result.stu.stuIdentificationNum);
					$('#stuGraduationCardNum').html(result.stu.stuGraduationCardNum);
					$('#stuMajorDegree').html(result.stu.stuMajorDegree);
					$('#stuSpecialty').html(result.stu.stuSpecialty);
				} else {
					window.location = "route/error.action";
				}
				console.log(stuName);
				console.log(result.stu.authCode);
			}
		});
	}
	function degreeAuth() {
		var dataAuth = {};
		dataAuth['stuName'] = $('#stuNameAuth').val();
		dataAuth['stuMajorDegreeCertNum'] = $('#stuMajorDegreeCertNum').val();
		dataAuth['stuPublicationDate'] = $('#stuPublicationDate').val();
		dataAuth['authCode'] = $('#authCodeAuth').val();

		console.log(JSON.stringify(dataAuth));
		$.ajax({
			type : "POST",
			url : "/graduate/stu/auth.action",
			data : JSON.stringify(dataAuth),
			dataType : "text",
			contentType : "application/json; charset=utf-8",
			success : function(responseText) {
				var result = JSON.parse(responseText);
				var stuName = result.stu.stuName;
				var stuMajorDegreeCertNum = result.stu.stuMajorDegreeCertNum;
				var stuPublicationDate = result.stu.stuPublicationDate;

				if (stuName) {
					$('#resultStuNameAuth').html(result.stu.stuName);
					$('#resultStuMajorDegreeCertNum').html(
							result.stu.stuMajorDegreeCertNum);
					$('#resultStuPublicationDate').html(
							result.stu.stuPublicationDate);
					$('#stuGender').html(result.stu.stuGender);
					$('#stuBrithday').html(result.stu.stuBrithday);
					$('#AuthstuSpecialty').html(result.stu.stuSpecialty);
					$('#AuthstuMajorDegree').html(result.stu.stuMajorDegree);
				}else {
					window.location = "route/errorAuth.action";
				}
				console.log(result);
				console.log(result.stu.authCode);
			}
		});
	}
	function getNewAuthCode() {
		//document.getElementById("imgAuthCode").src = "http://" + window.location.host + "/graduate/code.action";
		var imgSrc = "http://" + window.location.host + "/graduate/code.action";
		$("#imgAuthCode").attr("src", imgSrc);
		$("#imgAuthCodeAuth").attr("src", imgSrc);
		
	}
	
</script>
</head>
<body>
	<div class="header">
		<div class="header-container">
			<ul class="ulOne">
				<li><a href="">首页</a></li>
				<li><a href="#">联系方式</a></li>
				<li><a href="#">关于</a></li>
			</ul>
			<ul class="ulTwo">
				<li><a href="http://www.djtu.edu.cn">学校首页</a></li>
				<li><a href="#">教务处</a></li>
				<li><a href="#">学科学位办</a></li>
			</ul>
		</div>
	</div>
	<div class="content">
		<!--查询认证-->
		<div id="model1">
			<table>
				<tr>
					<td id="td1-1">
						<p class="headline1">大连交通大学</p>
						<p class="headline1">学位查询与认证系统</p>
						<p class="headline2">Dalian Jiaotong University</p>
						<p class="headline2">Dgree queries and certification system</p>
						<button id="search">
							<a href="#search-form1">查询</a>
						</button>
						<button id="identity">
							<a href="#search-form2">认证</a>
						</button>
						<p>*注意：“查询”功能主要供毕业生检索个人信息使用</p>
						<p>	     “认证”功能主要供用人单位等第三方使用</p>
					</td>
					<td>
						<div id="td1-2">
							<img src="<%=basePath%>resource/bg.jpg" />
						</div>
					</td>
				</tr>
			</table>
		</div>
		<!--学位查询-->
		<div id="search-form1" name="search-form1">
			<div>
				<div class="model-left">
					<p class="tab-title">
						<b>学位查询</b>
					</p>
					<table>
						<tr>
							<td>学生姓名：</td>
							<td><input type="text" name="stuName" id="stuName" /></td>
						</tr>
						<tr>
							<td>身份证号：</td>
							<td>
								<input type="text" name="stuIdentificationNum" id="stuIdentificationNum" />
							</td>
						</tr>
						<tr>
							<td>验证码：</td>
							<td>
								<input style="width: 100px;" type="text" name="authCode" id="authCode"  /> 
								 
								<a style="color: #3581B7;" onclick="getNewAuthCode();">
									<img id="imgAuthCode" src="<c:url value='/code.action' />" />
									<small><sub>看不清，换一张</sub></small>
								</a>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2">
								<button class="btn2" onclick="degreeQuery();">
										<a id="confirm" href="#feedback1">开始查询</a>
								</button>
							</td>
						</tr>
					</table>
				</div>
				<div class="model-right">
					<table>
						<tr>
							<td>填写说明：</td>
						</tr>
						<tr>
							<td>1.“姓名”需要与待查证书中的姓名书写一致；</td>
						</tr>
						<tr>
							<td>2.身份证号中的X不区分大小写；</td>
						</tr>
						<tr>
							<td>3.验证码不区分大小写，看不清点击图片即可更换。</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!--学位认证-->
		<div id="search-form2">
			<div>
				<div class="model-left">
					<p class="tab-title">
						<b>学位认证</b>
					</p>
					<table>
						<tr>
							<td>学生姓名：</td>
							<td><input type="text" name="stuName" id="stuNameAuth" /></td>
						</tr>
						<tr>
							<td>学位证号：</td>
							<td><input type="text" name="stuMajorDegreeCertNum"
								id="stuMajorDegreeCertNum" /></td>
						</tr>
						<tr>
							<td>发证日期：</td>
							<td><input type="date" placeholder="年/月/日" name="stuPublicationDate"
								id="stuPublicationDate"/></td>
						</tr>
						<tr>
							<td>验证码：</td>
							<td>
								<input style="width: 100px;"type="text" name="authCode" id="authCodeAuth" /> 
								<a style="color: #3581B7;" onclick="getNewAuthCode();">
									<img id="imgAuthCodeAuth" src="<c:url value='/code.action' />" />
									<small><sub>看不清，换一张</sub></small>
								</a>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2">
								<button class="btn2" onclick="degreeAuth(); ">
									<a id="confirm2" href="#feedback2">开始认证</a>
								</button>
							</td>
						</tr>
					</table>
				</div>
				<div class="model-right">
					<table>
						<tr>
							<td>填写说明：</td>
						</tr>
						<tr>
							<td>1.“姓名”需要与待查证书中的姓名书写一致；</td>
						</tr>
						<tr>
							<td>2.验证码不区分大小写，看不清点击图片即可更换。</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!--查询结果-->
		<div id="feedback1">
			<div>
				<div>
					<p class="tab-title">
						<b>查询结果</b>
					</p>
					<table>
						<tr>
							<td colspan="2">根据您输入的内容</td>
						</tr>
						<tr>
							<td>学生姓名：</td>
							<td id="resultStuName"></td>
						</tr>
						<tr>
							<td>身份证号：</td>
							<td id="resultStuIdentificationNum"></td>
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
						<!-- 
						<tr>
							<td>1654685132165</td>
							<td>文学</td>
							<td>日语+软件工程</td>
							<td>&nbsp;</td>
						</tr>
						 -->
						<tr>
							<td>&nbsp</td>
						</tr>
						<tr>
							<td colspan=5>*注意：最终学位信息以学位部门记载为准，如有疑义，请与我校相关主管部门联系。联系电话：0411-8622XXXX</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!--认证结果-->
		<div id="feedback2">
			<div>
				<div class="">
					<p class="tab-title">
						<b>认证结果</b>
					</p>
					<table>
						<tr>
							<td colspan="2">根据您输入的内容</td>
						</tr>
						<tr>
							<td>学生姓名：</td>
							<td id="resultStuNameAuth"></td>
						</tr>
						<tr>
							<td>学位证号：</td>
							<td id="resultStuMajorDegreeCertNum"></td>
						</tr>
						<tr>
							<td>发证日期：</td>
							<td id="resultStuPublicationDate"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2">我们查询到如下信息：</td>
						</tr>
						<!--</table>
						<table>-->
						<tr>
							<td>性别：</td>
							<td id="stuGender"></td>
							<td rowspan="4"><img src="<%=basePath%>resource/pic.png"></td>
						</tr>
						<tr>
							<td>出生日期：</td>
							<td id="stuBrithday"></td>
						</tr>
						<tr>
							<td>专业：</td>
							<td id="AuthstuSpecialty"></td>
						</tr>
						<tr>
							<td>学位类别：</td>
							<td id="AuthstuMajorDegree"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="3">*注意：最终学位信息以学位部门记载为准，如有疑义，请与我校相关主管部门联系。联系电话：0411-8622XXXX</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- 查询失败
		<div id="noResult1">
			<div>
				<div class="model-left">
					<p class="tab-title">
						<b>查询结果</b>
					</p>
					<table>
						<tr>
							<td colspan="2">根据您输入的内容</td>
						</tr>
						<tr>
							<td>学生姓名：</td>
							<td id="resultStuName"></td>
						</tr>
						<tr>
							<td>身份证号：</td>
							<td id="resultStuIdentificationNum"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<th colspan="6" style="color: red;">我们没有检索到对应的信息，请核实信息是否有误，并重试</th>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="3">*注意：最终学位信息以学位部门记载为准，如有疑义，请与我校相关主管部门联系。联系电话：0411-8622XXXX</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		认证失败
		<div id="noResult2">
			<div>
				<div class="model-left">
					<p class="tab-title">
						<b>认证结果</b>
					</p>
					<table>
						<tr>
							<td>学生姓名：</td>
							<td id="resultStuNameAuth"></td>
						</tr>
						<tr>
							<td>身份证号：</td>
							<td id="resultStuIdentificationNum"></td>
						</tr>
						<tr>
							<td>发证日期：</td>
							<td id="resultStuPublicationDate"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<th colspan="6" style="color: red;">我们没有检索到对应的信息，请核实信息是否有误，并重试</th>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="3">*注意：最终学位信息以学位部门记载为准，如有疑义，请与我校相关主管部门联系。联系电话：0411-8622XXXX</td>
						</tr>
					</table>
				</div>
			</div>
		</div> -->
	</div>

	<div class="footer">
		<div class="footerinside">
			<p class="footer-p">版权所有 ©2006 - 2015 大连交通大学 | 辽ICP备 05001355号</p>
			<p class="footer-p">学校地址：大连市沙河口区黄河路794号 邮编：116028
				联系我们：xcbu@djtu.edu.cn</p>
		</div>
	</div>
</body>
</html>
