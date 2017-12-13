package com.lanou.sm.admin.mapper;
import com.lanou.sm.admin.domain.Admin;
import com.lanou.sm.admin.domain.AdminRole;
import com.lanou.sm.role.domain.RoleInfo;
import com.lanou.sm.role.mapper.RoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/12/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:myBatis.xml")
public class AdminMapperTest {



    @Resource
    private AdminMapper adminMapper;

    @Resource
    private RoleMapper roleMapper;

    //管理员登录
    @Test
    public void findAdmin() throws Exception {
        Admin admin = new Admin("admin");
        adminMapper.findAdmin(admin);
    }

    //查询所有管理员
    @Test
    public void findAllAdmin() throws Exception {
        adminMapper.findAllAdmin();
    }


    @Test
    public void insertAdmin() throws Exception {
        Admin admin = new Admin("小乔","123","Xiaoqiao","123456789","213345@qq.com",new Date());
        adminMapper.insertAdmin(admin);
    }

    @Test
    public void findInsertAdmin() throws Exception {
        Admin admin = new Admin("小乔","123","Xiaoqiao","123456789","213345@qq.com",new Date());
        adminMapper.findInsertAdmin(admin);
    }

    @Test
    public void insertRoleInfo() throws Exception {
        RoleInfo info =new RoleInfo("报表管理员");
        adminMapper.insertRoleInfo(info);
        System.out.println(info);
    }

    @Test
    public void findRoleInfo() throws Exception {
        RoleInfo info =new RoleInfo(846,"报表管理员");
        RoleInfo roleInfo = roleMapper.findRoleInfo(info);
        System.out.println(roleInfo);
    }

    @Test
    public void insertAdminRole() throws Exception {
        Admin admin = new Admin(7001,"小乔","123","Xiaoqiao","123456789","213345@qq.com",new Date());
        RoleInfo info =new RoleInfo(846,"报表管理员");
        adminMapper.insertAdminRole(admin.getAdminId(),info.getRoleId());
    }

    @Test
    public void findInsertRoleInfo() throws Exception {
        RoleInfo info =new RoleInfo(846,"报表管理员");
        adminMapper.findInsertRoleInfo(info);
    }


    @Test
    public void deleteAdmin() throws Exception {
        Admin admin = new Admin(7001,"小乔","123","Xiaoqiao","123456789","213345@qq.com",new Date());
        adminMapper.deleteAdmin(admin);
    }

    @Test
    public void findAdminAndRole() throws Exception {
        Admin admin = new Admin(7021,"小乔","123","Xiaoqiao","123456789","213345@qq.com",new Date());
        adminMapper.findAdminAndRole(admin);
    }

    @Test
    public void deleteRoleInfo() throws Exception {
        Admin admin = new Admin(7021,"小乔","123","Xiaoqiao","123456789","213345@qq.com",new Date());
        List<AdminRole> adminAndRole = adminMapper.findAdminAndRole(admin);
        adminMapper.deleteRole_Info(adminAndRole);
    }

    @Test
    public void deleteAdmin_role() throws Exception {
        Admin admin = new Admin(7023,"小乔","123","Xiaoqiao","123456789","213345@qq.com",new Date());
        List<AdminRole> adminAndRole = adminMapper.findAdminAndRole(admin);
        adminMapper.deleteAdmin_role(adminAndRole);
    }

    @Test
    public void deleteRole_Info() throws Exception {
        Admin admin = new Admin(7008,"小乔","123","Xiaoqiao","123456789","213345@qq.com",new Date());
        List<AdminRole> adminAndRole = adminMapper.findAdminAndRole(admin);
        adminMapper.deleteRole_Info(adminAndRole);
    }

    @Test
    public void deleteRoleModule() throws Exception {
        Admin admin = new Admin(7008,"小乔","123","Xiaoqiao","123456789","213345@qq.com",new Date());
        List<AdminRole> adminAndRole = adminMapper.findAdminAndRole(admin);
        adminMapper.deleteRoleModule(adminAndRole);
    }

}