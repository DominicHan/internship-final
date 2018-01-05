package com.dominic.internshipfinal.domain.entity;

import java.io.Serializable;

public class Brand implements Serializable {
    private Integer id;

    private String brandName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }
}