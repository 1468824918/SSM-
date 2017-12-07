package com.lanou.sm.admin.controller;

import com.lanou.sm.admin.domain.Admin;
import com.lanou.sm.admin.service.AdminService;
import com.lanou.sm.admin.utils.GetFieldsErrors;
import com.lanou.sm.admin.utils.VerifyCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

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

    // 用户登录
    @RequestMapping("login")
    public String login(@Validated Admin admin,
                        BindingResult result,
                        Model model,
                        HttpServletRequest request,
                        HttpSession session,
                        String code) {
        Admin admins = adminServices.findAdmin(admin.getAdminCode());
        String codes = (String) session.getAttribute("code");
        if ("".equals(admin.getAdminCode())) {
            model.addAttribute("adminCodeError", GetFieldsErrors.getFieldsErrors(result, "adminCode"));
            model.addAttribute("admin", admin);
            return "login";
        } else if (admin.getAdminCode().trim().length() < 3 || admin.getAdminCode().trim().length() > 8) {
            model.addAttribute("adminCodeError", GetFieldsErrors.getFieldsErrors(result, "adminCode"));
            model.addAttribute("admin", admin);
            return "login";
        } else if (admins==null ||admins.getAdminCode().equals(admin.getAdminName())) {
            model.addAttribute("adminMsg", "对不起用户不存在");
            return "login";
        } else if ("".equals(admin.getPassword())) {
            model.addAttribute("passwordError", GetFieldsErrors.getFieldsErrors(result, "password"));
            return "login";
        } else if (admin.getPassword().trim().length() < 3 || admin.getPassword().trim().length() > 8) {
            model.addAttribute("passwordError", GetFieldsErrors.getFieldsErrors(result, "password"));
            return "login";
        }else if (!admins.getPassword().equals(admin.getPassword())){
            model.addAttribute("passwordMsg", "密码输入有误请重新输入");
            return "login";
        }
        else if ("".equals(code) || !code.equalsIgnoreCase(codes)) {
            model.addAttribute("codeError", "验证码输入错误");
            return "login";
        }
        model.addAttribute("admin", admin);
        return "index";
    }

    //验证码
    @RequestMapping(value = "/getVerifyCode")
    public void getVerifyCode(HttpServletResponse response, HttpSession session) throws IOException {
        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage();
        text = vc.getText();
        session.setAttribute("code", vc.getText());
        VerifyCode.output(image, response.getOutputStream());
    }

    //查询管理员
    @RequestMapping("/role/role_list")
    public String role_List(Model model) {
        List<Admin> adminList = adminServices.findAll();
        model.addAttribute("adminList",adminList);
        return "/role/role_list";
    }
//    //JSON/XML
//    @ResponseBody
//    @RequestMapping("/getall")
//    public Object jsonData() {
//        return Arrays.asList("aaa","bbb","ccc");
//    }

}
