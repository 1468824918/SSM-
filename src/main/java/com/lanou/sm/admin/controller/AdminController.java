package com.lanou.sm.admin.controller;

import com.lanou.sm.admin.domain.Admin;
import com.lanou.sm.admin.service.AdminService;
import com.lanou.sm.admin.utils.AjaxResult;
import com.lanou.sm.admin.utils.GetFieldsErrors;
import com.lanou.sm.admin.utils.VerifyCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * Created by dllo on 17/12/1.
 */
@Controller
public class AdminController {

    @Resource(name = "adminServices")
    private AdminService adminServices;

    public String text;

    @RequestMapping({"/index", "/"})
    public String home() {
        return "index";
    }

    /**
     * 用户登录
     * @param admin
     * @param session
     * @param code
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public String login(Admin admin, HttpSession session, String code) {
        return adminServices.findAdmin(admin,session,code);
    }

    /**
     * 验证码
     * @param response
     * @param session
     * @throws IOException
     */
    @RequestMapping(value = "/getVerifyCode")
    public void getVerifyCode(HttpServletResponse response, HttpSession session) throws IOException {
        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage();
        text = vc.getText();
        session.setAttribute("code", vc.getText());
        VerifyCode.output(image, response.getOutputStream());
    }

    @RequestMapping("findAllAdmin")
    @ResponseBody
    public AjaxResult findAll(){
        return new AjaxResult(adminServices.findAllAdmin());
    }
}
