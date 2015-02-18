package com.softfz.jdbc;
/**
 * 本项目中的jdbc操作异常抛出
 * @author Administrator
 *
 */
public class FBSQLException extends RuntimeException {

	public FBSQLException(String msg) {
		super(msg);
	}
}
