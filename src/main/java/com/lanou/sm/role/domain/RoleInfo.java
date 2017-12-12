package com.lanou.sm.role.domain;

import java.util.List;

/**
 * Created by dllo on 17/12/8.
 */
public class RoleInfo {
    private int roleId;
    private String roleName;
    private ModuleInfo moduleInfo;

    public RoleInfo() {
    }

    public RoleInfo(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public RoleInfo(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public ModuleInfo getModuleInfo() {
        return moduleInfo;
    }

    public void setModuleInfo(ModuleInfo moduleInfo) {
        this.moduleInfo = moduleInfo;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", moduleInfo=" + moduleInfo +
                '}';
    }

}
