package com.lanou.sm.admin.mapper;

import com.lanou.sm.admin.domain.Admin;
import com.lanou.sm.admin.domain.AdminRole;
import com.lanou.sm.admin.utils.PageBean;
import com.lanou.sm.role.domain.ModuleInfo;
import com.lanou.sm.role.domain.RoleInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Role;
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



    //删除管理员
    int deleteAdmin(Admin admin);

    //删除(role_module)表
    int deleteRoleModule(List<AdminRole> adminRole);




    //删除中间(admin_role)表
    int deleteAdmin_role(Admin admin);

    //删除角色(role_Info)表
    int deleteRole_Info( List<AdminRole> adminRole);




    //修改管理员
    int updateAdmin(Admin admin);

    //查询中间表的id(根据管理员id)(admin_role)
    List<AdminRole> findAdminAndRole(Admin admin);


    //查询权限
    List<ModuleInfo> findModule_info();


    //模糊查询
    List<Admin> likeAdmin( ModuleInfo moduleInfo,@Param("roleName") String roleName);


    //查询角色role_info表
    List<RoleInfo> findAllRole_info();





    //分页
    List<Admin> findAdminAndStartAndPageSize(int startPos,int pageSize);

    //查询有多少条数据
    PageBean<Admin> findAdminByPage();




}
