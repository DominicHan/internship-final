package com.dominic.internshipfinal.service.impl;

import com.dominic.internshipfinal.dao.GoodsType1Mapper;
import com.dominic.internshipfinal.dao.InterfinalAccountMapper;
import com.dominic.internshipfinal.dao.InterfinalBannerMapper;
import com.dominic.internshipfinal.domain.entity.GoodsType1;
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

    @Override
    public List<InterfinalBanner> getBanners() {
        return interfinalBannerMapper.selectAll();
    }

    @Override
    public List<GoodsType1> getGoodsType1() {
        return goodsType1Mapper.selectAll();
    }
}
