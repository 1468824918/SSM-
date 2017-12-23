package com.lanou.sm.account.service;

import com.lanou.sm.account.domain.Account;

import java.util.List;

/**
 * Created by dllo on 17/12/22.
 */
public interface AccountService {
    List<Account> findAccount();

    String updateStruts(Account account);
}
