package com.lanou.sm.admin.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * Created by dllo on 17/12/2.
 */
public class Admin {
    private int adminId;

    @NotBlank(message = "用户名不能为空")
    @Length(min = 3,max = 8,message = "用户名在3到8个字符之间")
    private String adminCode;

    @NotBlank(message = "密码不能为空")
    @Length(min = 3,max = 8,message = "密码名在3到8个字符之间")
    private String password;

    private String adminName;
    private String telephone;
    private String email;
    private Date enrollDate;

    public Admin() {
    }

    public Admin(int adminId, String adminCode, String password, String adminName, String telephone, String email, Date enrollate) {
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

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminCodde='" + adminCode + '\'' +
                ", password='" + password + '\'' +
                ", adminName='" + adminName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", enrolldate=" + enrollDate +
                '}';
    }
}
