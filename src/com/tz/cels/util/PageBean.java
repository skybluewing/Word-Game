package com.tz.cels.util;

import java.util.List;

/***
 * ���ݷ�ҳ����
 *
 */
public class PageBean<T> {

	private int page; // �鿴�ĵ�ǰҳ��
	private int limit;  // ÿҳ��ʾ������
	private int totalCount; // ��ҳ��
	private List<T> list;  // ��ҳ����
	
	
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

