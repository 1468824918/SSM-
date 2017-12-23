package com.lanou.sm.account.controller;

import com.lanou.sm.account.domain.Account;
import com.lanou.sm.account.service.AccountService;
import com.lanou.sm.admin.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/12/22.
 */
@Controller
public class AccountController {
    @Resource(name = "accountServices")
    private AccountService accountService;

    @RequestMapping("findAccount")
    @ResponseBody
    public AjaxResult findAccount() {
        return new AjaxResult(accountService.findAccount());
    }

    @RequestMapping("updateStruts")
    @ResponseBody
    public String updateStruts(Account account){
        String s = accountService.updateStruts(account);
        return s;
    }
}
