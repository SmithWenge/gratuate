package com.team.graduate.model;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	private int totalCount = 0;
	private int pageSize = 5;
	private int totalPage = 1;
	private int pageNum = 0;
	private String orderBy;
	private List<T> result;
	
	public Page() {
		
	}
	public Page(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		if (totalCount < 1) {
			totalCount = 0;
		}
		
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if (pageSize < 1) {
			pageSize = 1;
		}
		
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
//			if (totalPage == 1) {
				if (totalCount <= 0) {
					totalCount = 0;
				} else {
					totalPage = totalCount / pageSize;
					if (totalCount % pageSize > 0) {
						totalPage++;
					}
				}
//			}
		
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		if (pageNum < 0) {
			pageNum = 0;
		}
		if (pageNum > getTotalPage()) {
			pageNum = totalPage;
		}
		
		this.pageNum = pageNum;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		if (null == result) {
			result = new ArrayList<T>();
		}
		
		this.result = result;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public boolean hasNext() {
		return (pageNum + 1) < getTotalPage();
	}
	public boolean hasPre() {
		return (pageNum - 1) >= 0;
	}
	public int getPrePage() {
		if (hasPre()) {
			return pageNum - 1;
		} else {
			return pageNum;
		}
	}
	public int getNextPage() {
		if (hasNext()) {
			return pageNum + 1;
		} else {
			return pageNum;
		}
	}
}
