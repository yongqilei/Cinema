package com.movie.pncinema.common.error;

/**
 * 用户不存在异常类
 * @author leiyongqi
 *
 */
public class UserNotFoundException extends CustomException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1462346139444525514L;

	public UserNotFoundException(int code, String message) {
		super(message);
		this.code = code;
	}

}
