package com.lanou.sm.admin.domain;

import com.lanou.sm.role.domain.ModuleInfo;
import com.lanou.sm.role.domain.RoleInfo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/12/2.
 */
public class Admin{
    private int adminId;
    private String adminCode;
    private String password;
    private String adminName;
    private String telephone;
    private String email;
    private Date enrollDate;
    private ModuleInfo moduleInfo;
    private RoleInfo[] roleInfo;
    private List<AdminRole> adminRole;
    private List<RoleInfo> roleInfoList;

    public Admin(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public Admin(String adminCode, String password, String adminName, String telephone, String email, Date enrollDate) {
        this.adminCode = adminCode;
        this.password = password;
        this.adminName = adminName;
        this.telephone = telephone;
        this.email = email;
        this.enrollDate = enrollDate;
    }

    public Admin() {
    }

    public Admin(String adminCode) {
        this.adminCode = adminCode;
    }

    public Admin(int adminId, String adminCode, String password, String adminName, String telephone, String email, Date enrollDate) {
        this.adminId = adminId;
        this.adminCode = adminCode;
        this.password = password;
        this.adminName = adminName;
        this.telephone = telephone;
        this.email = email;
        this.enrollDate = enrollDate;
    }


    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public ModuleInfo getModuleInfo() {
        return moduleInfo;
    }

    public void setModuleInfo(ModuleInfo moduleInfo) {
        this.moduleInfo = moduleInfo;
    }

    public RoleInfo[] getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(RoleInfo[] roleInfo) {
        this.roleInfo = roleInfo;
    }

    public List<AdminRole> getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(List<AdminRole> adminRole) {
        this.adminRole = adminRole;
    }

    public List<RoleInfo> getRoleInfoList() {
        return roleInfoList;
    }

    public void setRoleInfoList(List<RoleInfo> roleInfoList) {
        this.roleInfoList = roleInfoList;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminCode='" + adminCode + '\'' +
                ", password='" + password + '\'' +
                ", adminName='" + adminName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", enrollDate=" + enrollDate +
                ", moduleInfo=" + moduleInfo +
                ", roleInfo=" + Arrays.toString(roleInfo) +
                ", adminRole=" + adminRole +
                ", roleInfoList=" + roleInfoList +
                '}';
    }
}
