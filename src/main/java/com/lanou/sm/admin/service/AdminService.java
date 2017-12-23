package com.lanou.sm.admin.service;

import com.lanou.sm.account.domain.Account;
import com.lanou.sm.admin.domain.Admin;
import com.lanou.sm.admin.utils.PageBean;
import com.lanou.sm.role.domain.ModuleInfo;
import com.lanou.sm.role.domain.RoleInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dllo on 17/12/2.
 */
public interface AdminService {

    String findAdmin(Admin admin, HttpSession session ,String code);

    List<Admin> findAllAdmin();

    String insertAdmin(Admin admin,String againPassword);

    String deleteAdmin(Admin admin);

    String updateAdmin(Admin admin);

    List<ModuleInfo> findModule_info();

    List<Admin> likeAdmin( ModuleInfo moduleInfo,String roleName);

    List<RoleInfo> findAllRole_info();

    Admin findAdminBySession(Admin admin);

    String updatePiAdmin(Admin admin);

    String updatePassword(String oldPassword,String password,String againPassword,HttpSession session);

    //分页
    List<Admin> findAdminAndStartAndPageSize(int startPos,int pageSize);

    //查询有多少条数据
    PageBean<Admin> findAdminByPage();

} 
