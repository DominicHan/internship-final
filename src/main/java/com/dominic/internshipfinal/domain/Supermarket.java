package com.dominic.internshipfinal.domain;

import com.dominic.internshipfinal.domain.entity.Goods;

import java.util.List;

public class Supermarket {

    private String title_pic;
    private List<Goods> goods_list;

    public Supermarket() {
    }

    public Supermarket(String title_pic, List<Goods> goods_list) {
        this.title_pic = title_pic;
        this.goods_list = goods_list;
    }

    public String getTitle_pic() {
        return title_pic;
    }

    public void setTitle_pic(String title_pic) {
        this.title_pic = title_pic;
    }

    public List<Goods> getGoods_list() {
        return goods_list;
    }

    public void setGoods_list(List<Goods> goods_list) {
        this.goods_list = goods_list;
    }
}
