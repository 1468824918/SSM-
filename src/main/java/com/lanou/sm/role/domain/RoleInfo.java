package com.lanou.sm.role.domain;

import com.lanou.sm.admin.domain.AdminRole;

import java.util.List;

/**
 * Created by dllo on 17/12/8.
 */
public class RoleInfo {
    private int roleId;
    private String roleName;
    private ModuleInfo moduleInfo;
    private List<AdminRole> adminRole;

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

    public List<AdminRole> getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(List<AdminRole> adminRole) {
        this.adminRole = adminRole;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", moduleInfo=" + moduleInfo +
                ", adminRole=" + adminRole +
                '}';
    }

}
