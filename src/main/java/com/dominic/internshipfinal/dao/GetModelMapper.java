package com.dominic.internshipfinal.dao;

import com.dominic.internshipfinal.domain.entity.GetModel;

import java.util.List;

public interface GetModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GetModel record);

    int insertSelective(GetModel record);

    GetModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GetModel record);

    int updateByPrimaryKey(GetModel record);

    List<String> selectAll();
}