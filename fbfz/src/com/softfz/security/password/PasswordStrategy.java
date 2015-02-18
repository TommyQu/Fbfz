package com.softfz.security.password;

/**
 * 密码加密策略接口
 * 
 * @author huihewu
 * @version V1.0
 * @time 2013-1-18 下午4:25:15
 */
public interface PasswordStrategy {
	/**
	 * 对旧密码进行加密
	 * 
	 * @param oldpassword
	 *            旧密码
	 * @param salt 盐值
	 * @return 新密码
	 */
	
	public String encrypt(String oldpassword,String salt);
}
