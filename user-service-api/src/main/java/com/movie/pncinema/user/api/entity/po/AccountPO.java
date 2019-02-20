package com.movie.pncinema.user.api.entity.po;

import java.util.Date;

/**
 * 账户持久化对象类，与数据库字段一致
 * @author leiyongqi
 *
 */
public class AccountPO {

	/**
	 * 账户ID
	 */
	private String id;
	
	/**
	 * 电话号码(用作用户名)
	 */
	private String tel;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 私钥(后期考虑将私钥存在文件服务器上)
	 */
	private String privateKey;
	
	/**
	 * 电子邮件
	 */
	private String email;
	
	/**
	 * 上次登录时间
	 */
	private Long lastLoginTime;
	
	/**
	 * 本次登录时间
	 */
	private Long loginTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Long getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}
	
}
