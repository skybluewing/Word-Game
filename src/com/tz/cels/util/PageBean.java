package com.tz.cels.util;

import java.util.List;

/***
 * 数据分页对象
 *
 */
public class PageBean<T> {

	private int page; // 查看的当前页码
	private int limit;  // 每页显示的条数
	private int totalCount; // 总页数
	private List<T> list;  // 分页数据
	
	
	public PageBean() {
		super();
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}

