package com.lanou.sm.admin.service.impl;

import com.lanou.sm.admin.domain.Admin;
import com.lanou.sm.admin.mapper.AdminMapper;
import com.lanou.sm.admin.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dllo on 17/12/2.
 */
@Service("adminServices")
public class AdminServiceImpl implements AdminService {

    @Resource(name = "adminMapper")
    private AdminMapper adminMapper;

    @Override
    public String findAdmin(Admin admin, HttpSession session ,String code) {
        Admin admins = adminMapper.findAdmin(admin);
        String codes = (String) session.getAttribute("code");
        if ("".equals(admin.getAdminCode())) {
            return "adminCode";
        } else if (admin.getAdminCode().trim().length() < 3 || admin.getAdminCode().trim().length() > 8) {
            return "adminCodeLength";
        } else if (admins == null || !admins.getAdminCode().equals(admin.getAdminCode())) {
            return "adminMsg";
        } else if ("".equals(admin.getPassword())) {
            return "Password";
        } else if (admin.getPassword().trim().length() < 3 || admin.getPassword().trim().length() > 8) {
            return "PasswordLength";
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

}
