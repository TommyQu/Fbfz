package com.softfz.security.password;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5算法密码加密
 * 
 * @author huihewu
 * @version V1.0
 * @time 2013-1-18 下午4:36:04
 */
public class MD5Strategy implements PasswordStrategy {

	@Override
	public String encrypt(String oldpassword, String salt) {
		byte[] old = oldpassword.getBytes();
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return oldpassword;
		}
		md5.update(salt.getBytes());
		md5.update(old);
		byte[] newpwd = md5.digest();
		String result = "";
		for (int i = 0; i < newpwd.length; i++) {
			result += Integer
					.toHexString((0xff & newpwd[i]) | 0x100)
					.substring(1,3);
		}

		return result;
	}

}
