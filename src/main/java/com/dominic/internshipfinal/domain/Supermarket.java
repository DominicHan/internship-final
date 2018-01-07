package com.dominic.internshipfinal.domain;

import com.dominic.internshipfinal.domain.entity.Goods;
import com.dominic.internshipfinal.domain.entity.GoodsType2;

import java.util.List;

public class Supermarket {

    private String titlePic;
    private List<Goods> goodsList;
    private List<GoodsType2> typeList;

    public Supermarket() {
    }

    public Supermarket(String titlePic, List<Goods> goodsList, List<GoodsType2> typeList) {
        this.titlePic = titlePic;
        this.goodsList = goodsList;
        this.typeList = typeList;
    }

    public String getTitlePic() {
        return titlePic;
    }

    public void setTitlePic(String titlePic) {
        this.titlePic = titlePic;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public List<GoodsType2> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<GoodsType2> typeList) {
        this.typeList = typeList;
    }
}
