package com.model;

import java.io.Serializable;
import java.util.List;

/**
 * 鍒嗛〉鏁版嵁妯″瀷
 * 
 * @author huihewu
 * @version V1.0
 * @time 2013-1-21 涓嬪崍12:48:32
 */
public class PageModel<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1798457886867200794L;
	//榛樿姣忛〉鏄剧ず鏉＄洰
	public static final int DEFAULT_PAGESIZE = 5;
	//褰撳墠椤�
	private int currentPage = 1;
	//姣忛〉鏄剧ず鏉℃暟
	private int pageSize = DEFAULT_PAGESIZE;
	//鎬昏褰曟暟
	private int allCount;
	//鏄剧ず鐨勮褰曢泦
	private List<T> result;
	/**
	 * 鑾峰彇鎬婚〉鏁�
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
