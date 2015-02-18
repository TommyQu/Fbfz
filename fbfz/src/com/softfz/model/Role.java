package com.softfz.model;

import java.util.ArrayList;
import java.util.List;

public class Role {

	private Integer roleid;
	private String rolename;
	private String roledesr;
	List<Integer> rolemenus=new ArrayList();
	List<Integer> roleresources=new ArrayList();;
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRoledesr() {
		return roledesr;
	}
	public void setRoledesr(String roledesr) {
		this.roledesr = roledesr;
	}
	public List<Integer> getRolemenus() {
		return rolemenus;
	}
	public void setRolemenus(List<Integer> rolemenus) {
		this.rolemenus = rolemenus;
	}
	public List<Integer> getRoleresources() {
		return roleresources;
	}
	public void setRoleresources(List<Integer> roleresources) {
		this.roleresources = roleresources;
	}
}
