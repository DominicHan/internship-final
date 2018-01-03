package com.dominic.internshipfinal.service.impl;

import com.dominic.internshipfinal.dao.GoodsMapper;
import com.dominic.internshipfinal.domain.entity.Goods;
import com.dominic.internshipfinal.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoods(Map map) {
        return goodsMapper.selectScreening(map);
    }
}
