package com.softfz.model;

public class MenuInfo {
	private int menuid;
	private Integer fatherid;
	private String menuname;
	private String menuuri;
	private int orderno;
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public Integer getFatherid() {
		return fatherid;
	}
	public void setFatherid(Integer fatherid) {
		this.fatherid = fatherid;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getMenuuri() {
		return menuuri;
	}
	public void setMenuuri(String menuuri) {
		this.menuuri = menuuri;
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	
}
