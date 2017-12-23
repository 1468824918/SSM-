package com.lanou.sm.account.domain;

import java.util.Date;

public class Account {
    private Integer accountId;//账号ID
    private Integer recommenderId;
    private String loginName;//登录账号
    private String loginPasswd;//登录密码
    private String status;//状态
    private Date createDate;//创建日期
    private Date pauseDate;//暂停日期
    private Date closeDate;//关闭日期
    private String realName;//真实姓名
    private String idcardNo;//经办人身份证
    private Date birthdate;//生日
    private String gender;//性别
    private String occupation;//占用
    private String telephone;//电话
    private String email;//邮箱
    private String mailaddress;//邮箱地址
    private String zipcode;//邮政编码
    private String qq;//qq
    private Date lastLoginTime;//最后登录时间
    private String lastLoginIp;//登录IP

    public Account() {
    }

    public Account(Integer accountId, String status) {
        this.accountId = accountId;
        this.status = status;
    }

    public Account(Integer accountId, Integer recommenderId, String loginName, String loginPasswd, String status, Date createDate, Date pauseDate, Date closeDate, String realName, String idcardNo, Date birthdate, String gender, String occupation, String telephone, String email, String mailaddress, String zipcode, String qq, Date lastLoginTime, String lastLoginIp) {
        this.accountId = accountId;
        this.recommenderId = recommenderId;
        this.loginName = loginName;
        this.loginPasswd = loginPasswd;
        this.status = status;
        this.createDate = createDate;
        this.pauseDate = pauseDate;
        this.closeDate = closeDate;
        this.realName = realName;
        this.idcardNo = idcardNo;
        this.birthdate = birthdate;
        this.gender = gender;
        this.occupation = occupation;
        this.telephone = telephone;
        this.email = email;
        this.mailaddress = mailaddress;
        this.zipcode = zipcode;
        this.qq = qq;
        this.lastLoginTime = lastLoginTime;
        this.lastLoginIp = lastLoginIp;
    }


    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getRecommenderId() {
        return recommenderId;
    }

    public void setRecommenderId(Integer recommenderId) {
        this.recommenderId = recommenderId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPasswd() {
        return loginPasswd;
    }

    public void setLoginPasswd(String loginPasswd) {
        this.loginPasswd = loginPasswd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getPauseDate() {
        return pauseDate;
    }

    public void setPauseDate(Date pauseDate) {
        this.pauseDate = pauseDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
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

    public String getMailaddress() {
        return mailaddress;
    }

    public void setMailaddress(String mailaddress) {
        this.mailaddress = mailaddress;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", loginName='" + loginName + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                ", realName='" + realName + '\'' +
                ", idcardNo='" + idcardNo + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}


