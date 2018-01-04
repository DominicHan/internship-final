package com.dominic.internshipfinal.domain.entity;

import java.util.Date;

public class MinePraise {
    private Integer mineInfoId;

    private String account;

    private Date submitTime;

    public Integer getMineInfoId() {
        return mineInfoId;
    }

    public void setMineInfoId(Integer mineInfoId) {
        this.mineInfoId = mineInfoId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }
}