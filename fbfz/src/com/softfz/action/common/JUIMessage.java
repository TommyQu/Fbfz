package com.softfz.action.common;

/**
 * { "statusCode":"200", "message":"\u64cd\u4f5c\u6210\u529f",
 * "navTabId":"demo_page1", "rel":"", "callbackType":"closeCurrent",
 * "forwardUrl":"", "confirmMsg":"" }
 * 
 * @author Administrator
 * 
 */
public class JUIMessage {
	private String statusCode = "200";
	private String message = "操作成功";
	private String navTabId;
	private String rel;
	private String callbackType;
	private String forwardUrl;
	private String confirmMsg;

	public void success() {

	}

	public void success(String message, boolean isClose, String navTabId) {
		this.message = message;
		if (isClose) {
			this.callbackType = "closeCurrent";
		}
		this.navTabId = navTabId;
	}

	public void fail() {
		fail("操作失败");
	}
	public void systemfail() {
		fail("系统异常，请联系管理员");
	}
	public void fail(String message) {
		this.statusCode = "300";
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

	public String getNavTabId() {
		return navTabId;
	}

	public String getRel() {
		return rel;
	}

	public String getCallbackType() {
		return callbackType;
	}

	public String getForwardUrl() {
		return forwardUrl;
	}

	public String getConfirmMsg() {
		return confirmMsg;
	}

}
