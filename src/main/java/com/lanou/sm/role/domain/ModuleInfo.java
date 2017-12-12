package com.lanou.sm.role.domain;

/**
 * Created by dllo on 17/12/8.
 */
public class ModuleInfo {
    private int moduleId;
    private String moduleName;

    public ModuleInfo(int moduleId, String moduleName) {
        this.moduleId = moduleId;
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


    @Override
    public String toString() {
        return "ModuleInfo{" +
                "moduleId=" + moduleId +
                ", moduleName='" + moduleName + '\'' +
                '}';
    }
}
