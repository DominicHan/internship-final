package com.dominic.internshipfinal.domain;

import com.dominic.internshipfinal.domain.entity.GoodsType1;
import com.dominic.internshipfinal.domain.entity.InterfinalBanner;

import java.util.List;

public class BusinessAffairs {

    private List<InterfinalBanner> banners;
    private List<GoodsType1> goods_types;

    public BusinessAffairs(List<InterfinalBanner> banners, List<GoodsType1> goods_types) {
        this.banners = banners;
        this.goods_types = goods_types;
    }

    public List<InterfinalBanner> getBanners() {
        return banners;
    }

    public void setBanners(List<InterfinalBanner> banners) {
        this.banners = banners;
    }

    public List<GoodsType1> getGoods_types() {
        return goods_types;
    }

    public void setGoods_types(List<GoodsType1> goods_types) {
        this.goods_types = goods_types;
    }
}
