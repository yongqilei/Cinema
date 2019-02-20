package com.movie.pncinema.us.service.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.pncinema.us.dao.AccountMapper;
import com.movie.pncinema.user.api.entity.po.AccountPO;
import com.movie.pncinema.user.api.service.LoginService;

/**
 * Login Service 实现类
 * 主要处理登录，Token等内容
 * @author leiyongqi
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public boolean login(String username, String inputPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AccountPO> list() {
		return accountMapper.list();
	}

}
