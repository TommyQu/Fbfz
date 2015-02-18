package com.softfz.action.frontweb;

import com.opensymphony.xwork2.ActionSupport;

public class CenterAction extends ActionSupport {
	private String msgtitle;
	private String center_url;
	private String center_script;

	public String goFail(String message) {
		this.msgtitle = message;
		this.center_script = "history.go(-1)";
		return "center";
	}

	public String goSuccess(String message, String url) {
		this.msgtitle = message;
		this.center_url = url;
		return "center";
	}

	public String goSystemFail() {
		this.msgtitle = "系统异常，请联系管理员";
		this.center_script = "history.go(-1)";
		return "center";
	}

	public String getMsgtitle() {
		return msgtitle;
	}

	public String getCenter_url() {
		return center_url;
	}

	public String getCenter_script() {
		return center_script;
	}


}
