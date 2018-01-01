package com.dominic.internshipfinal.domain.entity;

import java.util.Date;

public class Mine {
    private Integer id;

    private String storeUrl;

    private String storeTitle;

    private Date releaseDate;

    private String storeDescribe;

    private String storePraise;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreUrl() {
        return storeUrl;
    }

    public void setStoreUrl(String storeUrl) {
        this.storeUrl = storeUrl == null ? null : storeUrl.trim();
    }

    public String getStoreTitle() {
        return storeTitle;
    }

    public void setStoreTitle(String storeTitle) {
        this.storeTitle = storeTitle == null ? null : storeTitle.trim();
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getStoreDescribe() {
        return storeDescribe;
    }

    public void setStoreDescribe(String storeDescribe) {
        this.storeDescribe = storeDescribe == null ? null : storeDescribe.trim();
    }

    public String getStorePraise() {
        return storePraise;
    }

    public void setStorePraise(String storePraise) {
        this.storePraise = storePraise == null ? null : storePraise.trim();
    }
}