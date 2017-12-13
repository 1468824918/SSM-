package com.lanou.sm.admin.mapper;

import com.lanou.sm.admin.domain.Admin;
import com.lanou.sm.admin.domain.AdminRole;
import com.lanou.sm.role.domain.ModuleInfo;
import com.lanou.sm.role.domain.RoleInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dllo on 17/12/2.
 */
@Repository
public interface AdminMapper {
    //管理员登录
    Admin findAdmin(Admin admin);

    //查询所有管理员
    List<Admin> findAllAdmin();

    //插入管理员
    int insertAdmin(Admin admin);

    //查询插入的管理员
    Admin findInsertAdmin(Admin admin);

    //插入角色
    int insertRoleInfo(RoleInfo roleInfo);

    //查询插入以后的人
    RoleInfo findInsertRoleInfo(RoleInfo roleInfo);

    //向中间表插入两个(id)
    int insertAdminRole(int adminId,int roleId);



    //查询中间表的id(根据管理员id)(admin_role)
    List<AdminRole> findAdminAndRole(Admin admin);

    //删除管理员
    int deleteAdmin(Admin admin);

    //删除中间(admin_role)表
    int deleteAdmin_role(List<AdminRole> adminRole);

    //删除角色(role_Info)表
    int deleteRole_Info(List<AdminRole> adminRole);

    //删除(role_module)表
    int deleteRoleModule(List<AdminRole> adminRole);




}
