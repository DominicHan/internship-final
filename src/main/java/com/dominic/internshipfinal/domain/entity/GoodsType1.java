package com.dominic.internshipfinal.domain.entity;

public class GoodsType1 {
    private Integer id;

    private String goodsTypeName;

    private String goodsTypePicUrl;

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

    public String getGoodsTypePicUrl() {
        return goodsTypePicUrl;
    }

    public void setGoodsTypePicUrl(String goodsTypePicUrl) {
        this.goodsTypePicUrl = goodsTypePicUrl == null ? null : goodsTypePicUrl.trim();
    }
}