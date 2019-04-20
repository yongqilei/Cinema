package com.movie.pncinema.us.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.movie.pncinema.user.api.entity.po.AccountPO;

public interface AccountMapper {

	List<AccountPO> list();

	AccountPO selectByUsername(String username);

	AccountPO findByEmail(String email);
	
}
