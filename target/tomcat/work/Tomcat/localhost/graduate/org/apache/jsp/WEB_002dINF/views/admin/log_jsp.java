/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2015-04-04 07:16:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class log_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("<meta charset=\"utf-8\" />\n");
      out.write("<title>大连交通大学教务查询系统</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(basePath);
      out.write("resource/new_define.css\" />\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"");
      out.print(basePath);
      out.write("resource/jquery-2.1.0.js\"></script>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t//\t\tjQuery(document).ready(function($) {\n");
      out.write("\t//\t\t  $('#clickOne').click(function() {\n");
      out.write("\t//\t\t    alert('OK');\n");
      out.write("\t//\t\t  });\n");
      out.write("\t//\t\t});\n");
      out.write("\n");
      out.write("\t$(document).ready(function() {\n");
      out.write("\t\t//\t\t\t\t$('#blockOne').css('display', 'block');\n");
      out.write("\t\t//\t\t\t\t$('#blockTwo').css('display', 'none');\n");
      out.write("\n");
      out.write("\t\t$('#clickOne').click(function() {\n");
      out.write("\t\t\t$('#blockOne').css('display', 'block');\n");
      out.write("\n");
      out.write("\t\t\t$('#blockTwo').css('display', 'none');\n");
      out.write("\n");
      out.write("\t\t});\n");
      out.write("\n");
      out.write("\t\t$('#clickTwo').click(function() {\n");
      out.write("\t\t\t$('#blockTwo').css('display', 'block');\n");
      out.write("\n");
      out.write("\t\t\t$('#blockOne').css('display', 'none');\n");
      out.write("\t\t});\n");
      out.write("\n");
      out.write("\t});\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t    \t$( document ).ready(function() {\n");
      out.write("\t    \t\t$(\"#download\").click(function() {\n");
      out.write("\t    \t\t\t$(\"#download_form\").action = \"FileDownload\";\n");
      out.write("\t\t\t    \t$(\"#download_form\").method = \"post\";\n");
      out.write("\t\t\t    \t$(\"#download_form\").submit();\n");
      out.write("\t\t\t \t});\n");
      out.write("\t    \t});\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write("table {\n");
      out.write("\tborder: solid 1px;\n");
      out.write("\twidth: auto;\n");
      out.write("\theight: 40px;\n");
      out.write("\tline-height: 30px;\n");
      out.write("\tborder-bottom: solid 1px;\n");
      out.write("\t/*border-right: solid 1px;*/\n");
      out.write("}\n");
      out.write("\n");
      out.write("table input {\n");
      out.write("\twidth: 30px;\n");
      out.write("\theight: 22px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("button {\n");
      out.write("\tbackground: #3581B7;\n");
      out.write("\twidth: 140px;\n");
      out.write("\theight: auto;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#second_tab th {\n");
      out.write("\tcolor: #999999;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#first_tab {\n");
      out.write("\tborder: none;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#first_tab td {\n");
      out.write("\twidth: 120px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#left-tab {\n");
      out.write("\tdisplay: initial;\n");
      out.write("\tfloat: left;\n");
      out.write("\tmargin-left: 100px;\n");
      out.write("\tmargin-right: 100px;\n");
      out.write("\tmargin-top: 60px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#left-tab ul a {\n");
      out.write("\tfont-size: 24px;\n");
      out.write("\tcolor: #2A2C2E;\n");
      out.write("\tdisplay: list-item;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#right-tab {\n");
      out.write("\tfloat: left;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".active {\n");
      out.write("\tfont-weight: 600;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#blockTwo {\n");
      out.write("\tdisplay: none;\n");
      out.write("\tfloat: left;\n");
      out.write("\tmargin-top: 20px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t<!--页眉部分-->\n");
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
      out.write("\n");
      out.write("\t<form action=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" method=\"post\"\n");
      out.write("\t\tclass=\"form-horizontal\"></form>\n");
      out.write("\n");
      out.write("\t<div id=\"left-tab\">\n");
      out.write("\t\t<ul>\n");
      out.write("\t\t\t<li class=\"active\"><a id=\"clickOne\" href=\"#\">日志查询</a></li>\n");
      out.write("\t\t\t<li><a id=\"clickTwo\" href=\"#\">数据维护</a></li>\n");
      out.write("\t\t\t<li><a href=\"#\">页面设置</a></li>\n");
      out.write("\t\t\t<li><a href=\"#\">统计报表</a></li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t</div>\n");
      out.write("\t<div id=\"blockOne\">\n");
      out.write("\t\t<div id=\"right-tab\">\n");
      out.write("\t\t\t<!--表格-->\n");
      out.write("\t\t\t<table id=\"first_tab\">\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td colspan=\"\">请选择条件：</td>\n");
      out.write("\t\t\t\t\t<td colspan=\"\"><select name=\"years\">\n");
      out.write("\t\t\t\t\t\t\t<option value=\"2013\">2013</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"2012\">2012</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"2011\">2011</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"2010\">2010</option>\n");
      out.write("\t\t\t\t\t</select>年</td>\n");
      out.write("\t\t\t\t\t<td colspan=\"\"><select name=\"months\"><option\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"6\">6</option></select>月</td>\n");
      out.write("\t\t\t\t\t<td colspan=\"\"><select><option value=\"28\">28</option></select>日</td>\n");
      out.write("\t\t\t\t\t<td colspan=\"2\">&nbsp;</td>\n");
      out.write("\t\t\t\t\t<td><button>查询</button></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td><input type=\"checkbox\" name=\"all\" />全选</td>\n");
      out.write("\t\t\t\t\t<td colspan=\"\"><input type=\"checkbox\" name=\"ck\" />管理员登录</td>\n");
      out.write("\t\t\t\t\t<td colspan=\"1\"><input type=\"checkbox\" name=\"ck\" />用户操作</td>\n");
      out.write("\t\t\t\t\t<td colspan=\"\"><input type=\"checkbox\" name=\"ck\" />数据更新</td>\n");
      out.write("\t\t\t\t\t<td colspan=\"\"><input type=\"checkbox\" name=\"ck\" />系统信息</td>\n");
      out.write("\t\t\t\t\t<td colspan=\"\"><input type=\"checkbox\" name=\"ck\" />其他\n");
      out.write("\t\t\t\t\t</th>\n");
      out.write("\t\t\t\t\t<td><button>导出</button></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"col-md-10\" style=\"margin: 10px\">\n");
      out.write("\t\t\t\t\t<table class=\"table table-striped\">\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>时间</td>\n");
      out.write("\t\t\t\t\t\t\t<td>thread</td>\n");
      out.write("\t\t\t\t\t\t\t<td>level</td>\n");
      out.write("\t\t\t\t\t\t\t<td>class</td>\n");
      out.write("\t\t\t\t\t\t\t<td>事件描述</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!--right end-->\n");
      out.write("\t</div>\n");
      out.write("\t<div id=\"blockTwo\">\n");
      out.write("\t\t<h2>数据管理</h2>\n");
      out.write("\t\t<h3>\n");
      out.write("\t\t\n");
      out.write("\t\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t\t<form id=\"download_form\" action=\"/FileDownload\" method=\"post\">\n");
      out.write("\t\t\t\t\t操作模板文件 <button type=\"button\" class=\"btn btn-info\" id=\"download\">获取模板</button>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</h3>\n");
      out.write("\t\t<h3>\n");
      out.write("\t\t\t执行数据操作\n");
      out.write("\t\t\t<button>开始</button>\n");
      out.write("\t\t</h3>\n");
      out.write("\t\t<br />\n");
      out.write("\t\t<h2>照片管理</h2>\n");
      out.write("\t\t<h3>\n");
      out.write("\t\t\t上传照片数据\n");
      out.write("\t\t\t<button>开始</button>\n");
      out.write("\t\t</h3>\n");
      out.write("\t\t<h3>\n");
      out.write("\t\t\t清理无效照片\n");
      out.write("\t\t\t<button>开始</button>\n");
      out.write("\t\t</h3>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--  <tr>\n");
      out.write("\t<td>logId</td>\n");
      out.write("\t<td>createDate</td>\n");
      out.write("\t<td>thread</td>\n");
      out.write("\t<td>level</td>\n");
      out.write("\t<td>class</td>\n");
      out.write("\t<td>message</td>\n");
      out.write("</tr>\n");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\t-->");
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
    // /WEB-INF/views/admin/log.jsp(140,15) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/admin/log.action");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/views/admin/log.jsp(190,6) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/admin/log.jsp(190,6) '${logs}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${logs}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/views/admin/log.jsp(190,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("log");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t\t\t<tr>\n");
          out.write("\t\t\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${log.createDate }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("\t\t\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${log.thread }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("\t\t\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${log.level }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("\t\t\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${log.clazz }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("\t\t\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${log.message }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("\t\t\t\t\t\t\t</tr>\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent(null);
    // /WEB-INF/views/admin/log.jsp(245,0) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/admin/log.jsp(245,0) '${logs}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${logs}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/views/admin/log.jsp(245,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("log");
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t<tr>\n");
          out.write("\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${log.logId }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${log.createDate }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${log.thread }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${log.level }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${log.clazz }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${log.message }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("\t</tr>\n");
          out.write("\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }
}
