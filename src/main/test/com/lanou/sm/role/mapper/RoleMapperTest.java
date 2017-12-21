package com.lanou.sm.role.mapper;

import com.lanou.sm.role.domain.ModuleInfo;
import com.lanou.sm.role.domain.RoleInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/12/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:myBatis.xml")
public class RoleMapperTest {



    @Resource
    private RoleMapper roleMapper;

    //角色查询
    @Test
    public void findAll() throws Exception {
        List<ModuleInfo> moduleInfoList = roleMapper.findAll();
        System.out.println(moduleInfoList);
    }

    @Test
    public void insertRole() throws Exception {
        RoleInfo info = new RoleInfo("123");
        roleMapper.insertRole(info);
    }

    @Test
    public void findRoleInfo() throws Exception {
        RoleInfo info = new RoleInfo("关羽");
        RoleInfo roleInfo = roleMapper.findRoleInfo(info);
        System.out.println(roleInfo);
    }

    @Test
    public void deleteRole() throws Exception {
        RoleInfo info = new RoleInfo(832,"123");
        roleMapper.deleteRole(info);
    }

    @Test
    public void deleteRoleModule() throws Exception {
        RoleInfo info = new RoleInfo(314,"123");
        roleMapper.deleteRoleModule(info);
    }



    @Test
    public void deleteUpdateRole() throws Exception {
        RoleInfo info = new RoleInfo("苏烈");
        roleMapper.deleteUpdateRole(info);
    }

    @Test
    public void findModule_Info() throws Exception {
        roleMapper.findModule_Info();
    }

    @Test
    public void updateRoleInfoById() throws Exception {
        RoleInfo info = new RoleInfo(314,"苏烈");
        roleMapper.updateRoleInfoById(info);
    }

    @Test
    public void findRoleInfoAndModuleInfo() throws Exception {
        RoleInfo info = new RoleInfo(303,"苏烈");
        roleMapper.findRoleInfoAndModuleInfo(info);
    }
}