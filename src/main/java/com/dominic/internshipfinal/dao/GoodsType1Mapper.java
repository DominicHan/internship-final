package com.dominic.internshipfinal.dao;

import com.dominic.internshipfinal.domain.entity.GoodsType1;

import java.util.List;

public interface GoodsType1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsType1 record);

    int insertSelective(GoodsType1 record);

    GoodsType1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsType1 record);

    int updateByPrimaryKey(GoodsType1 record);

    List<GoodsType1> selectAll();
}