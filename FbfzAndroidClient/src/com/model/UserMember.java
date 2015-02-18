package com.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 鍓嶅彴浼氬憳鐢ㄦ埛
 * 
 * @author huihewu
 * 
 */
public class UserMember implements Serializable {
	/**
	 * 姝ｅ父鐘舵�
	 */
	public final static int NORMAL_STATE=1;
	/**
	 * 鍐荤粨鐘舵�
	 */
	public final static int LOCKED_STATE=2;
	/**
	 * web绔櫥闄�
	 */
	public final static int WEB_CLIENT=1;
	/**
	 * 鎵嬫満绔櫥闄�
	 */
	public final static int MOBILE_CLIENT=2;
	private int userid;
	private String username;
	private String password;
	private int usersex;
	private String email;
	private String qq;
	private String mobileno;
	private String regtime;
	private String lastlogintime;
	private String ip;
	private int state;
	private int client;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public int getUsersex() {
		return usersex;
	}
	public void setUsersex(int usersex) {
		this.usersex = usersex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public String getLastlogintime() {
		return lastlogintime;
	}
	public void setLastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getClient() {
		return client;
	}
	public void setClient(int client) {
		this.client = client;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserMember other = (UserMember) obj;
		if (userid != other.userid)
			return false;
		return true;
	}
	
	
}
