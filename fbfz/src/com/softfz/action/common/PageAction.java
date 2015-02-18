package com.softfz.action.common;

import com.opensymphony.xwork2.ActionSupport;
import com.softfz.model.PageModel;

public class PageAction extends ActionSupport{
	protected int currentPage=1;
	protected int pageSize=5;
	protected PageModel pageModel;

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public PageModel getPageModel() {
		return pageModel;
	}
}
