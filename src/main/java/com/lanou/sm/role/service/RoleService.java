package com.lanou.sm.role.service;

import com.lanou.sm.role.domain.ModuleInfo;
import com.lanou.sm.role.domain.RoleInfo;

import java.util.List;

/**
 * Created by dllo on 17/12/9.
 */
public interface RoleService {
    List<ModuleInfo> findAll();

    String insertRole(RoleInfo roleInfo,String[] moduleId);

    String deleteRole(RoleInfo roleInfo);

    String insertUpdateRoleInfo(RoleInfo roleInfo,String[] moduleId);

    List<ModuleInfo> findModule_Info();

    RoleInfo findRoleInfoAndModuleInfo(RoleInfo roleInfo);
}
