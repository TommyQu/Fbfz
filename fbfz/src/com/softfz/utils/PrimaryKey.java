package com.softfz.utils;

public class PrimaryKey {
	private static long key = System.currentTimeMillis();
	private PrimaryKey(){}
	public synchronized static String getKey() {
		return String.valueOf(key++);
	}
}
