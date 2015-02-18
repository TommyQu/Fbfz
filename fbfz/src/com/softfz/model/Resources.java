package com.softfz.model;
/**
 * 系统资源实体类
 * @author Administrator
 *
 */
public class Resources {
	private int resourceid;
	private String resourcename;
	private String resdescription;
	private String resuri;
	public int getResourceid() {
		return resourceid;
	}
	public void setResourceid(int resourceid) {
		this.resourceid = resourceid;
	}
	public String getResourcename() {
		return resourcename;
	}
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	public String getResdescription() {
		return resdescription;
	}
	public void setResdescription(String resdescription) {
		this.resdescription = resdescription;
	}
	public String getResuri() {
		return resuri;
	}
	public void setResuri(String resuri) {
		this.resuri = resuri;
	}
	
}
