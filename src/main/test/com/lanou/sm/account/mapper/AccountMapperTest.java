package com.lanou.sm.account.mapper;

import com.lanou.sm.account.domain.Account;
import com.lanou.sm.admin.mapper.AdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/12/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:myBatis.xml")
public class AccountMapperTest {


    @Resource
    private AccountMapper accountMapper;
    @Test
    public void findAccount() throws Exception {
        System.out.println(accountMapper.findAccount());
    }

    @Test
    public void updateStruts() throws Exception {
        accountMapper.updateStruts(new Account(1005,"0"));
    }

}