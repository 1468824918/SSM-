package com.lanou.sm.admin.controller;

import com.lanou.sm.admin.domain.Admin;
import com.lanou.sm.admin.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dllo on 17/12/7.
 */
@Controller
public class Skip {


    @RequestMapping("skipIndex")
    public String skipIndex() {
        return "index";
    }

    @RequestMapping("role")
    @ResponseBody
    public String skipRole() {
        return "role";
    }

    @RequestMapping("role_1")
    public String skipRole1() {
        return "role/role_list";
    }


    @RequestMapping("role_modi")
    public String skipRole_modi() {
        return "role/role_modi";
    }

    @RequestMapping("role_add")
    public String skipRole_add() {
        return "role/role_add";
    }

    @RequestMapping("admin_list")
    public String skipAdmin_list() {
        return "admin/admin_list";
    }

    @RequestMapping("fee_list")
    public String skipFee_list() {
        return "fee/fee_list";
    }

    @RequestMapping("account_list")
    public String account_list() {
        return "account/account_list";
    }

    @RequestMapping("service_list")
    public String service_list() {
        return "service/service_list";
    }

    @RequestMapping("bill_list")
    public String bill_list() {
        return "bill/bill_list";
    }

    @RequestMapping("report_list")
    public String report_list() {
        return "report/report_list";
    }

    @RequestMapping("user_info")
    public String user_info() {
        return "user/user_info";
    }

    @RequestMapping("user_modi_pwd")
    public String user_Modi_Pwd() {
        return "user/user_modi_pwd";
    }

    @RequestMapping("admin_add")
    public String admin_add() {
        return "admin/admin_add";
    }

    @RequestMapping("fee_add")
    public String fee_add() {
        return "fee/fee_add";
    }

    @RequestMapping("loginHtml")
    public String loginHtml(){
        return "login";
    }




}
