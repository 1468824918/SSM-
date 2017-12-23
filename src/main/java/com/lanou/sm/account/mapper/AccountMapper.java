package com.lanou.sm.account.mapper;

import com.lanou.sm.account.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("accountMapper")
public interface AccountMapper {

    //账务账号查询
    List<Account> findAccount();

    int updateStruts(Account account);



}