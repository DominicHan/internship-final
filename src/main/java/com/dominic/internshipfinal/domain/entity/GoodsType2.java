package com.dominic.internshipfinal.domain.entity;

import java.io.Serializable;

public class GoodsType2 implements Serializable{
    private Integer id;

    private String goodsTypeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName == null ? null : goodsTypeName.trim();
    }
}