package com.dominic.internshipfinal.dao;

import com.dominic.internshipfinal.domain.entity.InterfinalBanner;

import java.util.List;

public interface InterfinalBannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InterfinalBanner record);

    int insertSelective(InterfinalBanner record);

    InterfinalBanner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InterfinalBanner record);

    int updateByPrimaryKey(InterfinalBanner record);

    List<InterfinalBanner> selectAll();
}