/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2015-04-03 11:24:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<title>大连交通大学教务查询系统</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(basePath);
      out.write("resource/new_define.css\" />\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("resource/jquery-2.1.0.js\"></script>\n");
      out.write("<script>\n");
      out.write("/* \tjQuery(document).ready(function($){\n");
      out.write("\t\t$('#search').click(function(){\n");
      out.write("\t\t\talert('ok');\n");
      out.write("\t\t});\n");
      out.write("\t}); */\n");
      out.write("\t$(document).ready(function() {\n");
      out.write("\t\t// 设置查询,验证块隐藏\n");
      out.write("\t\t$('#search-form1').css('display', 'none');\n");
      out.write("\t\t$('#search-form2').css('display', 'none');\n");
      out.write("\n");
      out.write("\t\t//  点击显示隐藏查询\n");
      out.write("\t\t$('#search').click(function() {\n");
      out.write("\t\t\t$('#search-form2').css('display', 'none');\n");
      out.write("\t\t\t$('#feedback2').css('display', 'none');\n");
      out.write("\n");
      out.write("\t\t\t$('#search-form1').css('display', 'block');\n");
      out.write("\t\t});\n");
      out.write("\n");
      out.write("\t\t// 点击显示认证内容\n");
      out.write("\t\t$('#identity').click(function() {\n");
      out.write("\t\t\t$('#search-form1').css('display', 'none');\n");
      out.write("\t\t\t$('#feedback1').css('display', 'none');\n");
      out.write("\n");
      out.write("\t\t\t$('#search-form2').css('display', 'block');\n");
      out.write("\t\t\t//\t\t\t\t\t$('#templateDate').val('2008-07-01');\n");
      out.write("\t\t});\n");
      out.write("\n");
      out.write("\t\t//查看查询结果\n");
      out.write("\t\t$('#confirm').click(function() {\n");
      out.write("\t\t\t$('#feedback1').css('display', 'block');\n");
      out.write("\n");
      out.write("\t\t\t$('#feedback2').css('display', 'none');\n");
      out.write("\t\t});\n");
      out.write("\t\t//查看认证结果\n");
      out.write("\t\t$('#confirm2').click(function() {\n");
      out.write("\t\t\t$('#feedback2').css('display', 'block');\n");
      out.write("\n");
      out.write("\t\t\t$('#feedback1').css('display', 'none');\n");
      out.write("\t\t});\n");
      out.write("\t});\n");
      out.write("</script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tfunction degreeQuery() {\n");
      out.write("\t\tvar data = {};\n");
      out.write("\t\tdata['stuName'] = $('#stuName').val();\n");
      out.write("\t\tdata['stuIdentificationNum'] = $('#stuIdentificationNum').val();\n");
      out.write("\t\tdata['authCode'] = $('#authCode').val();\n");
      out.write("\n");
      out.write("\t\tconsole.log(JSON.stringify(data));\n");
      out.write("\t\t$.ajax({\n");
      out.write("\t\t\ttype : \"POST\",\n");
      out.write("\t\t\turl : \"/graduate/stu/select.action\",\n");
      out.write("\t\t\tdata : JSON.stringify(data),\n");
      out.write("\t\t\tdataType : \"text\",\n");
      out.write("\t\t\tcontentType : \"application/json; charset=utf-8\",\n");
      out.write("\t\t\tsuccess : function(responseText) {\n");
      out.write("\t\t\t\tvar result = JSON.parse(responseText);\n");
      out.write("\t\t\t\tvar stuName = result.stu.stuName;\n");
      out.write("\t\t\t\tvar stuIdentificationNum = result.stu.stuIdentificationNum;\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tif (stuName) {\n");
      out.write("\t\t\t\t\t$('#resultStuName').html(result.stu.stuName);\n");
      out.write("\t\t\t\t\t$('#resultStuIdentificationNum').html(\n");
      out.write("\t\t\t\t\t\t\tresult.stu.stuIdentificationNum);\n");
      out.write("\t\t\t\t\t$('#stuGraduationCardNum').html(result.stu.stuGraduationCardNum);\n");
      out.write("\t\t\t\t\t$('#stuMajorDegree').html(result.stu.stuMajorDegree);\n");
      out.write("\t\t\t\t\t$('#stuSpecialty').html(result.stu.stuSpecialty);\n");
      out.write("\t\t\t\t} else {\n");
      out.write("\t\t\t\t\twindow.location = \"route/error.action\";\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\tconsole.log(stuName);\n");
      out.write("\t\t\t\tconsole.log(result.stu.authCode);\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t}\n");
      out.write("\tfunction degreeAuth() {\n");
      out.write("\t\tvar dataAuth = {};\n");
      out.write("\t\tdataAuth['stuName'] = $('#stuNameAuth').val();\n");
      out.write("\t\tdataAuth['stuMajorDegreeCertNum'] = $('#stuMajorDegreeCertNum').val();\n");
      out.write("\t\tdataAuth['stuPublicationDate'] = $('#stuPublicationDate').val();\n");
      out.write("\t\tdataAuth['authCode'] = $('#authCodeAuth').val();\n");
      out.write("\n");
      out.write("\t\tconsole.log(JSON.stringify(dataAuth));\n");
      out.write("\t\t$.ajax({\n");
      out.write("\t\t\ttype : \"POST\",\n");
      out.write("\t\t\turl : \"/graduate/stu/auth.action\",\n");
      out.write("\t\t\tdata : JSON.stringify(dataAuth),\n");
      out.write("\t\t\tdataType : \"text\",\n");
      out.write("\t\t\tcontentType : \"application/json; charset=utf-8\",\n");
      out.write("\t\t\tsuccess : function(responseText) {\n");
      out.write("\t\t\t\tvar result = JSON.parse(responseText);\n");
      out.write("\t\t\t\tvar stuName = result.stu.stuName;\n");
      out.write("\t\t\t\tvar stuMajorDegreeCertNum = result.stu.stuMajorDegreeCertNum;\n");
      out.write("\t\t\t\tvar stuPublicationDate = result.stu.stuPublicationDate;\n");
      out.write("\n");
      out.write("\t\t\t\tif (stuName) {\n");
      out.write("\t\t\t\t\t$('#resultStuNameAuth').html(result.stu.stuName);\n");
      out.write("\t\t\t\t\t$('#resultStuMajorDegreeCertNum').html(\n");
      out.write("\t\t\t\t\t\t\tresult.stu.stuMajorDegreeCertNum);\n");
      out.write("\t\t\t\t\t$('#resultStuPublicationDate').html(\n");
      out.write("\t\t\t\t\t\t\tresult.stu.stuPublicationDate);\n");
      out.write("\t\t\t\t\t$('#stuGender').html(result.stu.stuGender);\n");
      out.write("\t\t\t\t\t$('#stuBrithday').html(result.stu.stuBrithday);\n");
      out.write("\t\t\t\t\t$('#AuthstuSpecialty').html(result.stu.stuSpecialty);\n");
      out.write("\t\t\t\t\t$('#AuthstuMajorDegree').html(result.stu.stuMajorDegree);\n");
      out.write("\t\t\t\t}else {\n");
      out.write("\t\t\t\t\twindow.location = \"route/errorAuth.action\";\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\tconsole.log(result);\n");
      out.write("\t\t\t\tconsole.log(result.stu.authCode);\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t}\n");
      out.write("\tfunction getNewAuthCode() {\n");
      out.write("\t\t//document.getElementById(\"imgAuthCode\").src = \"http://\" + window.location.host + \"/graduate/code.action\";\n");
      out.write("\t\tvar imgSrc = \"http://\" + window.location.host + \"/graduate/code.action\";\n");
      out.write("\t\t$(\"#imgAuthCode\").attr(\"src\", imgSrc);\n");
      out.write("\t\t$(\"#imgAuthCodeAuth\").attr(\"src\", imgSrc);\n");
      out.write("\t\t\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div class=\"header\">\n");
      out.write("\t\t<div class=\"header-container\">\n");
      out.write("\t\t\t<ul class=\"ulOne\">\n");
      out.write("\t\t\t\t<li><a href=\"#\">首页</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#\">联系方式</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#\">关于</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t\t<ul class=\"ulTwo\">\n");
      out.write("\t\t\t\t<li><a href=\"#\">学校首页</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#\">教务处</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#\">学科学位办</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"content\">\n");
      out.write("\t\t<!--查询认证-->\n");
      out.write("\t\t<div id=\"model1\">\n");
      out.write("\t\t\t<table>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td id=\"td1-1\">\n");
      out.write("\t\t\t\t\t\t<p class=\"headline1\">大连交通大学</p>\n");
      out.write("\t\t\t\t\t\t<p class=\"headline1\">学位查询与认证系统</p>\n");
      out.write("\t\t\t\t\t\t<p class=\"headline2\">Dalian Jiaotong University</p>\n");
      out.write("\t\t\t\t\t\t<p class=\"headline2\">Dgree queries and certification system</p>\n");
      out.write("\t\t\t\t\t\t<button id=\"search\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#search-form1\">查询</a>\n");
      out.write("\t\t\t\t\t\t</button>\n");
      out.write("\t\t\t\t\t\t<button id=\"identity\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#search-form2\">认证</a>\n");
      out.write("\t\t\t\t\t\t</button>\n");
      out.write("\t\t\t\t\t\t<p>*注意：“查询”功能主要供毕业生检索个人信息使用</p>\n");
      out.write("\t\t\t\t\t\t<p>\t     “认证”功能主要供用人单位等第三方使用</p>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t<div id=\"td1-2\">\n");
      out.write("\t\t\t\t\t\t\t<img src=\"");
      out.print(basePath);
      out.write("resource/bg.jpg\" />\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!--学位查询-->\n");
      out.write("\t\t<div id=\"search-form1\" name=\"search-form1\">\n");
      out.write("\t\t\t<div>\n");
      out.write("\t\t\t\t<div class=\"model-left\">\n");
      out.write("\t\t\t\t\t<p class=\"tab-title\">\n");
      out.write("\t\t\t\t\t\t<b>学位查询</b>\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t<table>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>学生姓名：</td>\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" name=\"stuName\" id=\"stuName\" /></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>身份证号：</td>\n");
      out.write("\t\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"stuIdentificationNum\" id=\"stuIdentificationNum\" />\n");
      out.write("\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>验证码：</td>\n");
      out.write("\t\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t\t<input style=\"width: 100px;\" type=\"text\" name=\"authCode\" id=\"authCode\"  /> \n");
      out.write("\t\t\t\t\t\t\t\t \n");
      out.write("\t\t\t\t\t\t\t\t<a style=\"color: #3581B7;\" onclick=\"getNewAuthCode();\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<img id=\"imgAuthCode\" src=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" />\n");
      out.write("\t\t\t\t\t\t\t\t\t<small><sub>看不清，换一张</sub></small>\n");
      out.write("\t\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\">\n");
      out.write("\t\t\t\t\t\t\t\t<button class=\"btn2\" onclick=\"degreeQuery();\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a id=\"confirm\" href=\"#feedback1\">开始查询</a>\n");
      out.write("\t\t\t\t\t\t\t\t</button>\n");
      out.write("\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"model-right\">\n");
      out.write("\t\t\t\t\t<table>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>填写说明：</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>1.“姓名”需要与待查证书中的姓名书写一致；</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>2.身份证号中的X不区分大小写；</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>3.验证码不区分大小写，看不清点击图片即可更换。</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!--学位认证-->\n");
      out.write("\t\t<div id=\"search-form2\">\n");
      out.write("\t\t\t<div>\n");
      out.write("\t\t\t\t<div class=\"model-left\">\n");
      out.write("\t\t\t\t\t<p class=\"tab-title\">\n");
      out.write("\t\t\t\t\t\t<b>学位认证</b>\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t<table>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>学生姓名：</td>\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" name=\"stuName\" id=\"stuNameAuth\" /></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>学位证号：</td>\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" name=\"stuMajorDegreeCertNum\"\n");
      out.write("\t\t\t\t\t\t\t\tid=\"stuMajorDegreeCertNum\" /></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>发证日期：</td>\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"date\" placeholder=\"年/月/日\" name=\"stuPublicationDate\"\n");
      out.write("\t\t\t\t\t\t\t\tid=\"stuPublicationDate\"/></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>验证码：</td>\n");
      out.write("\t\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t\t<input style=\"width: 100px;\"type=\"text\" name=\"authCode\" id=\"authCodeAuth\" /> \n");
      out.write("\t\t\t\t\t\t\t\t<a style=\"color: #3581B7;\" onclick=\"getNewAuthCode();\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<img id=\"imgAuthCodeAuth\" src=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\" />\n");
      out.write("\t\t\t\t\t\t\t\t\t<small><sub>看不清，换一张</sub></small>\n");
      out.write("\t\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\">\n");
      out.write("\t\t\t\t\t\t\t\t<button class=\"btn2\" onclick=\"degreeAuth(); \">\n");
      out.write("\t\t\t\t\t\t\t\t\t<a id=\"confirm2\" href=\"#feedback2\">开始认证</a>\n");
      out.write("\t\t\t\t\t\t\t\t</button>\n");
      out.write("\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"model-right\">\n");
      out.write("\t\t\t\t\t<table>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>填写说明：</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>1.“姓名”需要与待查证书中的姓名书写一致；</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>2.验证码不区分大小写，看不清点击图片即可更换。</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!--查询结果-->\n");
      out.write("\t\t<div id=\"feedback1\">\n");
      out.write("\t\t\t<div>\n");
      out.write("\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t<p class=\"tab-title\">\n");
      out.write("\t\t\t\t\t\t<b>查询结果</b>\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t<table>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\">根据您输入的内容</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>学生姓名：</td>\n");
      out.write("\t\t\t\t\t\t\t<td id=\"resultStuName\"></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>身份证号：</td>\n");
      out.write("\t\t\t\t\t\t\t<td id=\"resultStuIdentificationNum\"></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\">我们查询到如下信息：</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t\t<table>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>证书编号：</td>\n");
      out.write("\t\t\t\t\t\t\t<td>学位类型</td>\n");
      out.write("\t\t\t\t\t\t\t<td>专业</td>\n");
      out.write("\t\t\t\t\t\t\t<td>备注</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td id=\"stuGraduationCardNum\"></td>\n");
      out.write("\t\t\t\t\t\t\t<td id=\"stuMajorDegree\"></td>\n");
      out.write("\t\t\t\t\t\t\t<td id=\"stuSpecialty\"></td>\n");
      out.write("\t\t\t\t\t\t\t<td>----</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<!-- \n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>1654685132165</td>\n");
      out.write("\t\t\t\t\t\t\t<td>文学</td>\n");
      out.write("\t\t\t\t\t\t\t<td>日语+软件工程</td>\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t -->\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td colspan=5>*注意：最终学位信息以学位部门记载为准，如有疑义，请与我校相关主管部门联系。联系电话：0411-8622XXXX</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!--认证结果-->\n");
      out.write("\t\t<div id=\"feedback2\">\n");
      out.write("\t\t\t<div>\n");
      out.write("\t\t\t\t<div class=\"\">\n");
      out.write("\t\t\t\t\t<p class=\"tab-title\">\n");
      out.write("\t\t\t\t\t\t<b>认证结果</b>\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t<table>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\">根据您输入的内容</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>学生姓名：</td>\n");
      out.write("\t\t\t\t\t\t\t<td id=\"resultStuNameAuth\"></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>学位证号：</td>\n");
      out.write("\t\t\t\t\t\t\t<td id=\"resultStuMajorDegreeCertNum\"></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>发证日期：</td>\n");
      out.write("\t\t\t\t\t\t\t<td id=\"resultStuPublicationDate\"></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\">我们查询到如下信息：</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<!--</table>\n");
      out.write("\t\t\t\t\t\t<table>-->\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>性别：</td>\n");
      out.write("\t\t\t\t\t\t\t<td id=\"stuGender\"></td>\n");
      out.write("\t\t\t\t\t\t\t<td rowspan=\"4\"><img src=\"");
      out.print(basePath);
      out.write("resource/pic.png\"></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>出生日期：</td>\n");
      out.write("\t\t\t\t\t\t\t<td id=\"stuBrithday\"></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>专业：</td>\n");
      out.write("\t\t\t\t\t\t\t<td id=\"AuthstuSpecialty\"></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>学位类别：</td>\n");
      out.write("\t\t\t\t\t\t\t<td id=\"AuthstuMajorDegree\"></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"3\">*注意：最终学位信息以学位部门记载为准，如有疑义，请与我校相关主管部门联系。联系电话：0411-8622XXXX</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- 查询失败\n");
      out.write("\t\t<div id=\"noResult1\">\n");
      out.write("\t\t\t<div>\n");
      out.write("\t\t\t\t<div class=\"model-left\">\n");
      out.write("\t\t\t\t\t<p class=\"tab-title\">\n");
      out.write("\t\t\t\t\t\t<b>查询结果</b>\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t<table>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\">根据您输入的内容</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>学生姓名：</td>\n");
      out.write("\t\t\t\t\t\t\t<td id=\"resultStuName\"></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>身份证号：</td>\n");
      out.write("\t\t\t\t\t\t\t<td id=\"resultStuIdentificationNum\"></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<th colspan=\"6\" style=\"color: red;\">我们没有检索到对应的信息，请核实信息是否有误，并重试</th>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"3\">*注意：最终学位信息以学位部门记载为准，如有疑义，请与我校相关主管部门联系。联系电话：0411-8622XXXX</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t认证失败\n");
      out.write("\t\t<div id=\"noResult2\">\n");
      out.write("\t\t\t<div>\n");
      out.write("\t\t\t\t<div class=\"model-left\">\n");
      out.write("\t\t\t\t\t<p class=\"tab-title\">\n");
      out.write("\t\t\t\t\t\t<b>认证结果</b>\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t<table>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>学生姓名：</td>\n");
      out.write("\t\t\t\t\t\t\t<td id=\"resultStuNameAuth\"></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>身份证号：</td>\n");
      out.write("\t\t\t\t\t\t\t<td id=\"resultStuIdentificationNum\"></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>发证日期：</td>\n");
      out.write("\t\t\t\t\t\t\t<td id=\"resultStuPublicationDate\"></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<th colspan=\"6\" style=\"color: red;\">我们没有检索到对应的信息，请核实信息是否有误，并重试</th>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"3\">*注意：最终学位信息以学位部门记载为准，如有疑义，请与我校相关主管部门联系。联系电话：0411-8622XXXX</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div> -->\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div class=\"footer\">\n");
      out.write("\t\t<div class=\"footerinside\">\n");
      out.write("\t\t\t<p class=\"footer-p\">版权所有 ©2006 - 2015 大连交通大学 | 辽ICP备 05001355号</p>\n");
      out.write("\t\t\t<p class=\"footer-p\">学校地址：大连市沙河口区黄河路794号 邮编：116028\n");
      out.write("\t\t\t\t联系我们：xcbu@djtu.edu.cn</p>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/views/index.jsp(207,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/code.action");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /WEB-INF/views/index.jsp(269,40) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/code.action");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }
}
