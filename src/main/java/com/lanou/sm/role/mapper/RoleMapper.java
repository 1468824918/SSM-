package com.lanou.sm.role.mapper;

import com.lanou.sm.role.domain.ModuleInfo;
import com.lanou.sm.role.domain.RoleInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dllo on 17/12/9.
 */
@Repository("roleMapper")
public interface RoleMapper {
    //角色管理
    List<ModuleInfo> findAll();

    //插入角色
    int insertRole(RoleInfo roleInfo);

    //中间表插入数据
    int insertRoleModule(RoleInfo roleInfo);

    //根据名字查找人
    RoleInfo findRoleInfo(RoleInfo roleInfo);

    //删除角色
    int deleteRole(RoleInfo roleInfo);

    //删除中间表id
    int deleteRoleModule(RoleInfo roleInfo);



    //查询所有权限
    List<ModuleInfo> findModule_Info();




    //修改名字
    int updateRoleInfoById(RoleInfo roleInfo);

    //删除要修改的人,根据名字删除
    int deleteUpdateRole(RoleInfo roleInfo);

}
