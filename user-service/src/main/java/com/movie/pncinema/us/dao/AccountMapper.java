package com.movie.pncinema.us.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.movie.pncinema.user.api.entity.po.AccountPO;

public interface AccountMapper {

	public List<AccountPO> list();
	
}
