package com.movie.pncinema.common.dto;

/**
 * 接口统一返回对象实体类
 * @author leiyongqi
 *
 * @param <T> 泛型
 */
public class ResponseEntity<T> extends BaseDto {
	
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
