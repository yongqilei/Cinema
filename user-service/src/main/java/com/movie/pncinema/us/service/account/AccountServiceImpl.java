package com.movie.pncinema.us.service.account;

import com.movie.pncinema.us.dao.AccountMapper;
import com.movie.pncinema.user.api.entity.po.AccountPO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 账户服务实现类
 * @author leiyongqi
 */
public class AccountServiceImpl {

    @Autowired
    private AccountMapper accountMapper;

    public boolean usernameExist(String username) {
        AccountPO account = accountMapper.selectByUsername(username);
        if (account != null) {
            return true;
        }
        return false;
    }

    public boolean emailExist(String email) {
        AccountPO account = accountMapper.findByEmail(email);
        if (account != null) {
            return true;
        }
        return false;
    }
}
