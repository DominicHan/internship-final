package com.dominic.internshipfinal.service;

import com.dominic.internshipfinal.domain.entity.Goods;
import com.dominic.internshipfinal.domain.entity.GoodsType1;
import com.dominic.internshipfinal.domain.entity.GoodsType2;
import com.dominic.internshipfinal.domain.entity.InterfinalBanner;

import java.util.List;

public interface MainService {
    // 获取首页banner图
    List<InterfinalBanner> getBanners();
    // 获取首页商品分类数据
    List<GoodsType1> getGoodsType1();
    // 根据id获取商品2级类型
    List<String> getGoodsType2();
    // 获取商品列表
    List<Goods> getGoods();
}
