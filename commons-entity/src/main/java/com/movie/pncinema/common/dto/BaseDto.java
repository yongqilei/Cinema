package com.movie.pncinema.common.dto;

/**
 * Base数据传输对象类，所有DTO需要继承这个类
 * @author leiyongqi
 *
 */
public class BaseDto {

	protected Integer code;
	
	protected String message;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
