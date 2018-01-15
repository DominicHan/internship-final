package com.dominic.internshipfinal.dao;

import com.dominic.internshipfinal.domain.entity.Mine;

import java.util.List;

public interface MineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mine record);

    int insertSelective(Mine record);

    Mine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mine record);

    int updateByPrimaryKey(Mine record);

    List<Mine> selectAll();
}