package com.lanou.sm.admin.controller;

import com.lanou.sm.admin.domain.Admin;
import com.lanou.sm.admin.service.AdminService;
import com.lanou.sm.admin.utils.AjaxResult;
import com.lanou.sm.admin.utils.GetFieldsErrors;
import com.lanou.sm.admin.utils.VerifyCode;
import com.lanou.sm.role.domain.ModuleInfo;
import com.lanou.sm.role.domain.RoleInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dllo on 17/12/1.
 */
@Controller
public class AdminController {
    private Admin admin1;
    public String text;

    @Resource(name = "adminServices")
    private AdminService adminServices;


    @RequestMapping({"/index", "/"})
    public String home() {
        return "index";
    }

    /**
     * 用户登录
     *
     * @param admin
     * @param session
     * @param code
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public String login(Admin admin, HttpSession session, String code) {
        return adminServices.findAdmin(admin, session, code);
    }

    /**
     * 验证码
     *
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

    /**
     * 管理员查询(五表联查)
     *
     * @return
     */
    @RequestMapping("findAllAdmin")
    @ResponseBody
    public AjaxResult findAll() {
        return new AjaxResult(adminServices.findAllAdmin());
    }

    /**
     * 插入管理员
     *
     * @param admin
     * @param againPassword
     * @return
     */
    @RequestMapping("insertAdminAndRoleInfo")
    @ResponseBody
    public String insertAdmin(Admin admin, String againPassword) {
        return adminServices.insertAdmin(admin, againPassword);
    }

    /**
     * 删除管理员
     *
     * @param admin
     * @return
     */
    @RequestMapping("deleteAdmin")
    @ResponseBody
    public String deleteAdmin(Admin admin) {
        return adminServices.deleteAdmin(admin);
    }


    @RequestMapping("skipAdmin_modi")
    @ResponseBody
    public String admin_modi(Admin admin){
        admin1 = admin;
        System.out.println(admin);
        return "success";
    }

    @RequestMapping("Admin_modi")
    public String Admin_modi(){
        return "admin/admin_modi";
    }

    /**
     * 回显信息
     * @return
     */
    @RequestMapping("lookAdmin")
    @ResponseBody
    public AjaxResult lookAdmin(){
        return new AjaxResult(admin1);
    }


    /**
     * 修改管理员
     * @param admin
     * @return
     */
    @RequestMapping("updateAdmin")
    @ResponseBody
    public String updateAdmin(Admin admin){
        String s = adminServices.updateAdmin(admin);
        return s;
    }

    /**
     * 查询权限
     * @return
     */
    @RequestMapping("findModule_info")
    @ResponseBody
    public AjaxResult findModule_info(){
        return new AjaxResult(adminServices.findModule_info());
    }

    /**
     * 模糊查询
     * @param moduleInfo
     * @return
     */
    @RequestMapping("likeAdmin")
    @ResponseBody
    public AjaxResult likeAdmin(ModuleInfo moduleInfo,String roleName){
        return new AjaxResult(adminServices.likeAdmin(moduleInfo,roleName));
    }

    /**
     * 查询角色
     * @return
     */
    @RequestMapping("findAllRole_info")
    @ResponseBody
    public AjaxResult findAllRole_info(){
        return new AjaxResult(adminServices.findAllRole_info());
    }


    public Admin getAdmin() {
        return admin1;
    }

    public void setAdmin(Admin admin) {
        this.admin1 = admin;
    }
}
