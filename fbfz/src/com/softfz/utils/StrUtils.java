package com.softfz.utils;

/**
 * 字符串判断工具类
 * 
 * @author Administrator
 * 
 */
public class StrUtils {
	public static boolean isEmpty(String msg) {
		return msg == null || msg.trim().length() <= 0;
	}

	public static boolean isNotEmpty(String msg) {
		return !isEmpty(msg);
	}
}
