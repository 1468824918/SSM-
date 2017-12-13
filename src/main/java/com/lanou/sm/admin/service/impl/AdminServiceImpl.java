package com.lanou.sm.admin.service.impl;

import com.lanou.sm.admin.domain.Admin;
import com.lanou.sm.admin.domain.AdminRole;
import com.lanou.sm.admin.mapper.AdminMapper;
import com.lanou.sm.admin.service.AdminService;
import com.lanou.sm.role.domain.RoleInfo;
import com.lanou.sm.role.mapper.RoleMapper;
import com.lanou.sm.role.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/12/2.
 */
@Service("adminServices")
public class AdminServiceImpl implements AdminService {

    @Resource(name = "adminMapper")
    private AdminMapper adminMapper;

    @Resource(name = "roleMapper")
    private RoleMapper roleMapper;

    @Override
    public String findAdmin(Admin admin, HttpSession session, String code) {
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

    @Override
    public String insertAdmin(Admin admin,String againPassword) {
        if ("".equals(admin.getAdminName()) || admin.getAdminName() == null || admin.getAdminName().trim().length() < 3 || admin.getAdminName().trim().length() > 15) {
            return "nameNull";
        } else if (admin.getAdminCode().trim().length() < 3 || admin.getAdminCode().trim().length() > 15) {
            return "adminCodeLength";
        } else if ("".equals(admin.getPassword()) || admin.getPassword() == null || admin.getPassword().trim().length() < 3 || admin.getPassword().trim().length() > 15) {
            return "passwordError";
        } else if (!againPassword.equals(admin.getPassword())) {
            return "againPasswordError";
        } else if ("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$".equals(admin.getTelephone()) || "^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$".equals(admin.getTelephone()) || "".equals(admin.getTelephone())) {
            return "telephoneError";
        } else if ("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$".equals(admin.getEmail()) || "".equals(admin.getEmail())) {
            return "emailError";
        } else if (admin.getRoleInfo().length == 0) {
            return "roleInfoNameError";
        } else {
           //插入管理员
            Admin a = new Admin(new Date());
            admin.setEnrollDate(a.getEnrollDate());
            adminMapper.insertAdmin(admin);

            //查询插入的管理员
            Admin insertAdmin = adminMapper.findInsertAdmin(admin);

            for (RoleInfo info : admin.getRoleInfo()) {
                //根据名字插入角色
                adminMapper.insertRoleInfo(info);
                //查询插入的角色
                RoleInfo role = adminMapper.findInsertRoleInfo(info);
                //向中间表插入数据
                adminMapper.insertAdminRole(insertAdmin.getAdminId(), role.getRoleId());
            }
            return "success";
        }
    }

    @Override
    public String deleteAdmin(Admin admin) {
        List<AdminRole> adminAndRole = adminMapper.findAdminAndRole(admin);
        adminMapper.deleteRole_Info(adminAndRole);
        adminMapper.deleteRoleModule(adminAndRole);
        adminMapper.deleteAdmin_role(adminAndRole);
        adminMapper.deleteAdmin(admin);
        return "success";
    }

}
