package com.movie.pncinema.common.dto;

/**
 * 接口统一返回对象实体类
 * @author leiyongqi
 *
 */
public class ResponseEntity extends BaseDto {
	
	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
