package com.softfz.service;
/**
 * 自定义业务逻辑异常
 * @author Administrator
 *
 */
public class FBfzServiceException extends RuntimeException {
	public FBfzServiceException(String message) {
		super(message);
	}
}
