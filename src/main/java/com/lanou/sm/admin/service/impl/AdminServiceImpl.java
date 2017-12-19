package com.lanou.sm.admin.service.impl;

import com.lanou.sm.admin.domain.Admin;
import com.lanou.sm.admin.domain.AdminRole;
import com.lanou.sm.admin.mapper.AdminMapper;
import com.lanou.sm.admin.service.AdminService;
import com.lanou.sm.role.domain.ModuleInfo;
import com.lanou.sm.role.domain.RoleInfo;
import com.lanou.sm.role.mapper.RoleMapper;
import com.lanou.sm.role.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dllo on 17/12/2.
 */
@Service("adminServices")
public class AdminServiceImpl implements AdminService {

    @Resource(name = "adminMapper")
    private AdminMapper adminMapper;

    @Override
    public String findAdmin(Admin admin, HttpSession session, String code) {
        Admin admins = adminMapper.findAdmin(admin);
        String codes = (String) session.getAttribute("code");
        if ("".equals(admin.getAdminCode())) {
            return "adminCode";
        } else if (admin.getAdminCode().trim().length() < 3 || admin.getAdminCode().trim().length() > 8) {
            return "adminCodeLength";
        } else if ("".equals(admin.getPassword())) {
            return "Password";
        } else if (admin.getPassword().trim().length() < 3 || admin.getPassword().trim().length() > 8) {
            return "PasswordLength";
        } else if (admins == null || !admins.getAdminCode().equals(admin.getAdminCode())) {
            return "adminMsg";
        } else if (!admins.getPassword().equals(admin.getPassword())) {
            return "passwordMsg";
        } else if ("".equals(code) || !code.equalsIgnoreCase(codes)) {
            return "codeError";
        }
        return "index";
    }

    @Override
    public List<Admin> findAllAdmin() {
        return adminMapper.findAllAdmin();
    }

    @Override
    public String insertAdmin(Admin admin, String againPassword) {
        //手机号正则表达式
        Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
        Matcher matcher = regex.matcher(admin.getTelephone());

        //邮箱正则表达式
        String email = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regexs = Pattern.compile(email);
        Matcher matchers = regexs.matcher(admin.getEmail());

        if ("".equals(admin.getAdminName()) || admin.getAdminName() == null || admin.getAdminName().trim().length() < 3 || admin.getAdminName().trim().length() > 15) {
            return "nameNull";
        } else if (admin.getAdminCode().trim().length() < 3 || admin.getAdminCode().trim().length() > 15) {
            return "adminCodeLength";
        } else if ("".equals(admin.getPassword()) || admin.getPassword() == null || admin.getPassword().trim().length() < 3 || admin.getPassword().trim().length() > 15) {
            return "passwordError";
        } else if (!againPassword.equals(admin.getPassword())) {
            return "againPasswordError";
        } else if (!matcher.matches()) {
            return "telephoneError";
        } else if (!matchers.matches()) {
            return "emailError";
        } else if (admin.getRoleInfo().length == 0) {
            return "roleInfoNameError";
        } else {
            //插入管理员
            Admin a = new Admin(new Date());
            admin.setEnrollDate(a.getEnrollDate());
            adminMapper.insertAdmin(admin);

            for (RoleInfo info : admin.getRoleInfo()) {
                int s = Integer.parseInt(info.getRoleName());
                adminMapper.insertAdminRole(admin.getAdminId(), s);
            }
            return "success";
        }
    }

    @Override
    public String deleteAdmin(Admin admin) {
        List<AdminRole> adminAndRole = adminMapper.findAdminAndRole(admin);
        adminMapper.deleteAdmin_role(admin);
        adminMapper.deleteAdmin(admin);
        return "success";
    }

    @Override
    public String updateAdmin(Admin admin) {
        //手机号正则表达式
        Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
        Matcher matcher = regex.matcher(admin.getTelephone());

        //邮箱正则表达式
        String email = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regexs = Pattern.compile(email);
        Matcher matchers = regexs.matcher(admin.getEmail());

        if ("".equals(admin.getAdminName()) || admin.getAdminName() == null || admin.getAdminName().trim().length() < 3 || admin.getAdminName().trim().length() > 15) {
            return "nameNull";
        } else if (!matcher.matches()) {
            return "telephoneError";
        } else if (!matchers.matches()) {
            return "emailError";
        } else {
            List<AdminRole> adminRoleList = adminMapper.findAdminAndRole(admin);
            adminMapper.deleteAdmin_role(admin);


            Admin a = new Admin(new Date());
            admin.setEnrollDate(a.getEnrollDate());
            adminMapper.updateAdmin(admin);

            for (RoleInfo roleInfo : admin.getRoleInfo()) {
                int s = Integer.parseInt(roleInfo.getRoleName());
                System.out.println(s);
                adminMapper.insertAdminRole(admin.getAdminId(), s);
            }

        }
        return "success";
    }

    @Override
    public List<ModuleInfo> findModule_info() {
        return adminMapper.findModule_info();
    }


    @Override
    public List<Admin> likeAdmin(ModuleInfo moduleInfo, String roleName) {
        return adminMapper.likeAdmin(moduleInfo, roleName);
    }

    @Override
    public List<RoleInfo> findAllRole_info() {
        return adminMapper.findAllRole_info();
    }

}
