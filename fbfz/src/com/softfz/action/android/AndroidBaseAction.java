package com.softfz.action.android;

import com.softfz.action.common.PageAction;
import com.softfz.model.AndroidMessage;

public class AndroidBaseAction extends PageAction {
	private AndroidMessage message = new AndroidMessage();

	public AndroidMessage getMessage() {
		return message;
	}

	/**
	 * 正常返回
	 * 
	 * @param data
	 * @return
	 */
	public String success(Object data) {
		// 正常
		message.setData(data);
		message.setSuccess(true);
		return "androidclient";
	}

	/**
	 * 业务逻辑异常返回
	 * 
	 * @param msg
	 * @return
	 */
	public String fail(String msg) {
		message.setData(msg);
		message.setSuccess(false);
		return "androidclient";
	}

	public String systemfail() {
		message.setData("系统异常");
		message.setSuccess(false);
		return "androidclient";
	}
}
