package com.team.graduate.common;

import com.team.graduate.model.Page;

public class PageComponent<T> {
	private Page<T> page;
	private String pageNoName = "pageNo";
	private String pageName = "Page";
	private String totalCountName = "totalCount";
	private String url;
	
	public PageComponent(Page<T> page) {
		this.page = page;
	}
	
	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}

	public String getPageNoName() {
		return pageNoName;
	}

	public void setPageNoName(String pageNoName) {
		this.pageNoName = pageNoName;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getTotalCountName() {
		return totalCountName;
	}

	public void setTotalCountName(String totalCountName) {
		this.totalCountName = totalCountName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPageHTML() {
		StringBuffer buffer = new StringBuffer("<div class=\"row\" style=\"margin-top: 5px\">");
		if (page.getTotalCount() <= 0) {
			buffer.append("<div class=\"col-sm-2\"><button type=\"button\" class=\"btn btn-default\" disabled=\"disabled\">没有数据</button></div>");
		} else {
			buffer.append("<div class=\"col-sm-3\"><button type=\"button\" class=\"btn btn-default\" disabled=\"disabled\">每页").append(page.getPageSize()).append("/").append(page.getTotalCount()).append("条记录  第").append(page.getPageNum() + 1).append("/").append(page.getTotalPage()).append("页</button></div>");
		}
		
		if (page.hasNext() && page.hasPre()) {
			buffer.append("<div class=\"col-sm-1\"><button type=\"button\" class=\"btn btn-default\" id=\"").append(this.pageName).append("\" ").append(" onclick=\"get").append(this.pageName).append("(0);").append("\">首页</button></div>");
			buffer.append("<div class=\"col-sm-1\"><button type=\"button\" class=\"btn btn-default\" id=\"").append(this.pageName).append("\" ").append(" onclick=\"get").append(this.pageName).append("(").append(page.getPrePage()).append(");").append("\">上一页</button></div>");
			buffer.append("<div class=\"col-sm-1\"><button type=\"button\" class=\"btn btn-default\" id=\"").append(this.pageName).append("\" ").append(" onclick=\"get").append(this.pageName).append("(").append(page.getNextPage()).append(");").append("\">下一页</button></div>");
			buffer.append("<div class=\"col-sm-1\"><button type=\"button\" class=\"btn btn-default\" id=\"").append(this.pageName).append("\" ").append(" onclick=\"get").append(this.pageName).append("(").append(page.getTotalPage() - 1).append(");").append("\">末页</button></div>");
		} else if (page.hasNext()) {
			buffer.append("<div class=\"col-sm-1\"><button type=\"button\" class=\"btn btn-default\" disabled=\"disabled\"").append(">首页</button></div>");
			buffer.append("<div class=\"col-sm-1\"><button type=\"button\" class=\"btn btn-default\" disabled=\"disabled\"").append(">上一页</button></div>");
			buffer.append("<div class=\"col-sm-1\"><button type=\"button\" class=\"btn btn-default\" id=\"").append(this.pageName).append("\" ").append(" onclick=\"get").append(this.pageName).append("(").append(page.getNextPage()).append(");").append("\">下一页</button></div>");
			buffer.append("<div class=\"col-sm-1\"><button type=\"button\" class=\"btn btn-default\" id=\"").append(this.pageName).append("\" ").append(" onclick=\"get").append(this.pageName).append("(").append(page.getTotalPage() - 1).append(");").append("\">末页</button></div>");
		} else if (page.hasPre()){
			buffer.append("<div class=\"col-sm-1\"><button type=\"button\" class=\"btn btn-default\" id=\"").append(this.pageName).append("\" ").append(" onclick=\"get").append(this.pageName).append("(0);").append("\">首页</button></div>");
			buffer.append("<div class=\"col-sm-1\"><button type=\"button\" class=\"btn btn-default\" id=\"").append(this.pageName).append("\" ").append(" onclick=\"get").append(this.pageName).append("(").append(page.getPrePage()).append(");").append("\">上一页</button></div>");
			buffer.append("<div class=\"col-sm-1\"><button type=\"button\" class=\"btn btn-default\" disabled=\"disabled\"").append(">下一页</button></div>");
			buffer.append("<div class=\"col-sm-1\"><button type=\"button\" class=\"btn btn-default\" disabled=\"disabled\"").append(">末页</button></div>");
		} else {
			buffer.append("<div class=\"col-sm-1\"><button type=\"button\" class=\"btn btn-default\" disabled=\"disabled\"").append(">首页</button></div>");
			buffer.append("<div class=\"col-sm-1\"><button type=\"button\" class=\"btn btn-default\" disabled=\"disabled\"").append(">上一页</button></div>");
			buffer.append("<div class=\"col-sm-1\"><button type=\"button\" class=\"btn btn-default\" disabled=\"disabled\"").append(">下一页</button></div>");
			buffer.append("<div class=\"col-sm-1\"><button type=\"button\" class=\"btn btn-default\" disabled=\"disabled\"").append(">末页</button></div>");
		}
		buffer.append("<div class=\"col-sm-3\"><div class=\"row\"><div class=\"form-group\">");
		buffer.append("<div class=\"col-sm-5\">");
		buffer.append("<input type=\"text\" class=\"form-control\" id=\'gopage\' placeholder=\"0\">");
		buffer.append("</div>");
		buffer.append("<div class=\"col-sm-1\">");
		buffer.append("<button type=\"button\" class=\"btn btn-default\"").append(" onclick=\"get").append(this.pageName).append("(document.getElementById(\'gopage\').value);\"").append(">跳转</button>");
		buffer.append("</div>");
		buffer.append("</div></div></div>");
		buffer.append("<input type=\"hidden\" id=\"").append(this.totalCountName).append("\" name=\"").append(this.totalCountName).append("\" value=\"").append(page.getTotalCount()).append("\"/>");
		buffer.append("<input type=\"hidden\" id=\"").append(this.pageNoName).append("\" name=\"").append(this.pageNoName).append("\" value=\"").append(page.getPageNum()).append("\"/>");
		buffer.append("</div>");
		buffer.append("<script type=\"text/javascript\" charset=\"utf-8\">");
		buffer.append("function get").append(this.pageName).append("(page) {");
		buffer.append("document.forms[0].").append(this.pageNoName).append(".value=page; ");
		buffer.append("document.forms[0].").append(this.totalCountName).append(".value='").append(page.getTotalCount()).append("';");
		buffer.append("document.forms[0].action='").append(this.url).append("';");
		buffer.append("document.forms[0].submit();");
		buffer.append("}</script>");
		
		return buffer.toString();
	}
}

