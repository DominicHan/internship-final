package com.dominic.internshipfinal.domain.entity;

import java.util.Date;

public class InterfinalAccount {
    private Integer id;

    private String account;

    private String accountPassword;

    private String gesturesPassword;

    private String nick;

    private String mobile;

    private String storePicUrl;

    private Date createTime;

    private Integer roleId;

    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword == null ? null : accountPassword.trim();
    }

    public String getGesturesPassword() {
        return gesturesPassword;
    }

    public void setGesturesPassword(String gesturesPassword) {
        this.gesturesPassword = gesturesPassword == null ? null : gesturesPassword.trim();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getStorePicUrl() {
        return storePicUrl;
    }

    public void setStorePicUrl(String storePicUrl) {
        this.storePicUrl = storePicUrl == null ? null : storePicUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }
}