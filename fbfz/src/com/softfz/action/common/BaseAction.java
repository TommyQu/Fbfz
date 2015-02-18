package com.softfz.action.common;

public class BaseAction extends PageAction {
	protected JUIMessage message = new JUIMessage();

	public JUIMessage getMessage() {
		return message;
	}

	protected String returnjson() {
		return "message";
	}
}
