package com.lanou.sm.role.domain;

import java.io.Serializable;

/**
 * Created by dllo on 17/12/8.
 */
public class ModuleInfo implements Serializable{
    private int moduleId;
    private String moduleName;
    private RoleInfo roleInfo;

    public ModuleInfo(String moduleName, RoleInfo roleInfo) {
        this.moduleName = moduleName;
        this.roleInfo = roleInfo;
    }

    public ModuleInfo(int moduleId, String moduleName) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
    }


    public ModuleInfo(String moduleName) {
        this.moduleName = moduleName;
    }

    public ModuleInfo() {
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public RoleInfo getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(RoleInfo roleInfo) {
        this.roleInfo = roleInfo;
    }

    @Override
    public String toString() {
        return "ModuleInfo{" +
                "moduleId=" + moduleId +
                ", moduleName='" + moduleName + '\'' +
                ", roleInfo=" + roleInfo +
                '}';
    }
}
