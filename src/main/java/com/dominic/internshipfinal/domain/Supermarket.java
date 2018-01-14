package com.dominic.internshipfinal.domain;

import com.dominic.internshipfinal.domain.entity.Goods;
import com.dominic.internshipfinal.domain.entity.GoodsType2;

import java.util.List;

public class Supermarket {

    private String titlePic;
    private List<GoodsList> goodsList;
    private List<String> typeList;

    public Supermarket() {
    }

    public Supermarket(String titlePic, List<GoodsList> goodsList, List<String> typeList) {
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

    public List<GoodsList> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsList> goodsList) {
        this.goodsList = goodsList;
    }

    public List<String> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }

    public static class GoodsList {
        private String typeName;
        private List<Goods> list;

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public List<Goods> getList() {
            return list;
        }

        public void setList(List<Goods> list) {
            this.list = list;
        }
    }
}