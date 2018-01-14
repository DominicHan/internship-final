package com.dominic.internshipfinal.dao;

import com.dominic.internshipfinal.domain.entity.GoodsType1;
import com.dominic.internshipfinal.domain.entity.GoodsType2;

import java.util.List;

public interface GoodsType2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsType2 record);

    int insertSelective(GoodsType2 record);

    GoodsType2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsType2 record);

    int updateByPrimaryKey(GoodsType2 record);

    String selectNameByPrimaryKey(Integer id);
    List<String> selectAll();
}