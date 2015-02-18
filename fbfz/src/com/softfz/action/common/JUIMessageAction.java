package com.softfz.action.common;

import com.opensymphony.xwork2.ActionSupport;

public class JUIMessageAction extends ActionSupport{
	protected JUIMessage message = new JUIMessage();

	public JUIMessage getMessage() {
		return message;
	}

	protected String returnjson() {
		return "message";
	}
}
