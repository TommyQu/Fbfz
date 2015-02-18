package com.softfz.model;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据模型
 * 
 * @author huihewu
 * @version V1.0
 * @time 2013-1-21 下午12:48:32
 */
public class PageModel<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1798457886867200794L;
	//默认每页显示条目
	public static final int DEFAULT_PAGESIZE = 5;
	//当前页
	private int currentPage = 1;
	//每页显示条数
	private int pageSize = DEFAULT_PAGESIZE;
	//总记录数
	private int allCount;
	//显示的记录集
	private List<T> result;
	/**
	 * 获取总页数
	 * @return
	 */
	public int getAllPage() {
		return (this.allCount - 1) / this.pageSize + 1;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

}
