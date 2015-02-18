package com.softfz.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 系统用户实体类
 * 
 * @author huihewu
 * 
 */
public class SystemUser {
	/**
	 * 正常状态常量值
	 */
	public final static int SYSTEM_USER_NORMAL_STATE = 1;
	/**
	 * 冻结状态常量值
	 */
	public final static int SYSTEM_USER_LOCKED_STATE = 2;
	private int userid;
	private String loginname;
	private String username;
	private String password;
	private Date opentime;
	private int usersex;
	private String idcard;
	private String email;
	private String mobileno;
	private String address;
	/**
	 * 1:正常，2：冻结
	 */
	private int state;
	/**
	 * 用户拥有的角色信息
	 */
	private List<Integer> userroles;

	public List<Integer> getUserroles() {
		return userroles;
	}

	public void setUserroles(List<Integer> userroles) {
		this.userroles = userroles;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getOpentime() {
		return opentime;
	}

	public void setOpentime(Date opentime) {
		this.opentime = opentime;
	}

	public int getUsersex() {
		return usersex;
	}

	public void setUsersex(int usersex) {
		this.usersex = usersex;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
