package com.dominic.internshipfinal.domain.entity;

import java.io.Serializable;

public class ShoppingCart implements Serializable {
    private String account;

    private Integer goodsId;

    private Integer purchaseQuantity;

    public String getAccountId() {
        return account;
    }

    public void setAccountId(String accountId) {
        this.account = accountId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Integer purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }
}