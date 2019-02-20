package com.movie.pncinema.user.api.service;

import java.util.List;

import com.movie.pncinema.user.api.entity.po.AccountPO;

/**
 * login service
 * @author leiyongqi
 */
public interface LoginService {

	/**
	 * 
	 * @return 是否登陆成功
	 */
	public boolean login(String username, String inputPassword);
	
	public List<AccountPO> list();
	
}
