package com.lanou.sm.account.service.impl;

import com.lanou.sm.account.domain.Account;
import com.lanou.sm.account.mapper.AccountMapper;
import com.lanou.sm.account.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/22.
 */
@Service("accountServices")
public class AccountServiceImpl implements AccountService{
    @Resource(name = "accountMapper")
    private AccountMapper accountMapper;
    @Override
    public List<Account> findAccount() {
        return accountMapper.findAccount();
    }

    @Override
    public String updateStruts(Account account) {
        accountMapper.updateStruts(account);
        return "success";
    }
}
