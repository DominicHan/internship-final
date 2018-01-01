package com.dominic.internshipfinal.domain.entity;

public class Goods {
    private Integer id;

    private String goodsName;

    private String goodsPicUrl;

    private Integer goodsPrices;

    private String goodsOriginalPrices;

    private Integer highPraiseNum;

    private String highPraiseProbability;

    private Integer sales;

    private String newProduct;

    private String clothesLength;

    private String area;

    private String applicablePeople;

    private String activeTags;

    private String storeName;

    private String brand;

    private String getModel;

    private Integer inventory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsPicUrl() {
        return goodsPicUrl;
    }

    public void setGoodsPicUrl(String goodsPicUrl) {
        this.goodsPicUrl = goodsPicUrl == null ? null : goodsPicUrl.trim();
    }

    public Integer getGoodsPrices() {
        return goodsPrices;
    }

    public void setGoodsPrices(Integer goodsPrices) {
        this.goodsPrices = goodsPrices;
    }

    public String getGoodsOriginalPrices() {
        return goodsOriginalPrices;
    }

    public void setGoodsOriginalPrices(String goodsOriginalPrices) {
        this.goodsOriginalPrices = goodsOriginalPrices == null ? null : goodsOriginalPrices.trim();
    }

    public Integer getHighPraiseNum() {
        return highPraiseNum;
    }

    public void setHighPraiseNum(Integer highPraiseNum) {
        this.highPraiseNum = highPraiseNum;
    }

    public String getHighPraiseProbability() {
        return highPraiseProbability;
    }

    public void setHighPraiseProbability(String highPraiseProbability) {
        this.highPraiseProbability = highPraiseProbability == null ? null : highPraiseProbability.trim();
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(String newProduct) {
        this.newProduct = newProduct == null ? null : newProduct.trim();
    }

    public String getClothesLength() {
        return clothesLength;
    }

    public void setClothesLength(String clothesLength) {
        this.clothesLength = clothesLength == null ? null : clothesLength.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getApplicablePeople() {
        return applicablePeople;
    }

    public void setApplicablePeople(String applicablePeople) {
        this.applicablePeople = applicablePeople == null ? null : applicablePeople.trim();
    }

    public String getActiveTags() {
        return activeTags;
    }

    public void setActiveTags(String activeTags) {
        this.activeTags = activeTags == null ? null : activeTags.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getGetModel() {
        return getModel;
    }

    public void setGetModel(String getModel) {
        this.getModel = getModel == null ? null : getModel.trim();
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
}