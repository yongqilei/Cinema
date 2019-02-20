package com.movie.pncinema.common.error;

/**
 * 自定义异常基础类，所有的自定义异常需要继承这个类
 * 需要单独处理的异常类型继承此类，共通异常类直接使用此类就行
 * @author leiyongqi
 *
 */
public class CustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4170461717108618802L;
	
	protected Integer code;

	public CustomException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	

}
