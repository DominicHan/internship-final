package com.dominic.internshipfinal.service.impl;

import com.dominic.internshipfinal.dao.*;
import com.dominic.internshipfinal.domain.entity.Goods;
import com.dominic.internshipfinal.domain.entity.GoodsType1;
import com.dominic.internshipfinal.domain.entity.GoodsType2;
import com.dominic.internshipfinal.domain.entity.InterfinalBanner;
import com.dominic.internshipfinal.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    InterfinalBannerMapper interfinalBannerMapper;

    @Autowired
    GoodsType1Mapper goodsType1Mapper;

    @Autowired
    GoodsType2Mapper goodsType2Mapper;

    @Autowired
    GoodsMapper goodsMapper;


    @Override
    public List<InterfinalBanner> getBanners() {
        return interfinalBannerMapper.selectAll();
    }

    @Override
    public List<GoodsType1> getGoodsType1() {
        return goodsType1Mapper.selectAll();
    }

    @Override
    public String getGoodsType2(int id) {
        return goodsType2Mapper.selectNameByPrimaryKey(id);
    }

    @Override
    public List<Goods> getGoods() {
        return goodsMapper.selectAll();
    }
}
