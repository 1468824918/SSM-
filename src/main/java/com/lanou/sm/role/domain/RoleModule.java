package com.lanou.sm.role.domain;

/**
 * Created by dllo on 17/12/9.
 */
public class RoleModule {
    private int roleId;
    private int moduleId;

    public RoleModule() {
    }

    public RoleModule(int roleId, int moduleId) {
        this.roleId = roleId;
        this.moduleId = moduleId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public String toString() {
        return "RoleModule{" +
                "roleId=" + roleId +
                ", moduleId=" + moduleId +
                '}';
    }
}
