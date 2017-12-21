package com.lanou.sm.role.service.impl;

import com.lanou.sm.role.domain.ModuleInfo;
import com.lanou.sm.role.domain.RoleInfo;
import com.lanou.sm.role.mapper.RoleMapper;
import com.lanou.sm.role.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/9.
 */
@Service("roleServices")
public class RoleServiceImpl implements RoleService {

    @Resource(name = "roleMapper")
    private RoleMapper roleMapper;

    @Override
    public List<ModuleInfo> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public String insertRole(RoleInfo roleInfo, String[] moduleId) {
        if ("".equals(roleInfo.getRoleName()) || roleInfo.getRoleName() == null) {
            return "nameNull";
        } else if (moduleId.length == 0) {
            return "integerError";
        } else {
            roleMapper.insertRole(roleInfo);
            RoleInfo info = roleMapper.findRoleInfo(roleInfo);
            for (String s : moduleId) {
                ModuleInfo moduleInfo = new ModuleInfo();
                int i = Integer.parseInt(s);
                moduleInfo.setModuleId(i);
                info.setModuleInfo(moduleInfo);
                info.setRoleName(roleInfo.getRoleName());
                roleMapper.insertRoleModule(info);
            }
        }

        return "success";
    }

    @Override
    public String deleteRole(RoleInfo roleInfo) {
        roleMapper.deleteRole(roleInfo);
        roleMapper.deleteRoleModule(roleInfo);
        return "success";
    }

    @Override
    public String insertUpdateRoleInfo(RoleInfo roleInfo, String[] moduleId) {
        roleMapper.updateRoleInfoById(roleInfo);
        roleMapper.deleteRoleModule(roleInfo);

        //重新插入
        if ("".equals(roleInfo.getRoleName()) || roleInfo.getRoleName() == null) {
            return "nameNull";
        } else if (moduleId.length == 0) {
            return "IntegerError";
        } else {
            RoleInfo info = roleMapper.findRoleInfo(roleInfo);
            for (String str : moduleId) {
                ModuleInfo module = new ModuleInfo();
                int i = Integer.parseInt(str);
                module.setModuleId(i);
                info.setModuleInfo(module);
                info.setRoleName(roleInfo.getRoleName());
                roleMapper.insertRoleModule(info);
            }
        }
        return "success";
    }

    @Override
    public List<ModuleInfo> findModule_Info() {
        return roleMapper.findModule_Info();
    }

    @Override
    public RoleInfo findRoleInfoAndModuleInfo(RoleInfo roleInfo) {
        return roleMapper.findRoleInfoAndModuleInfo(roleInfo);
    }
}
