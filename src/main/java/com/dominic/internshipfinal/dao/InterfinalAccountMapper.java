package com.dominic.internshipfinal.dao;

import com.dominic.internshipfinal.entity.InterfinalAccount;

public interface InterfinalAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InterfinalAccount record);

    int insertSelective(InterfinalAccount record);

    InterfinalAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InterfinalAccount record);

    int updateByPrimaryKey(InterfinalAccount record);
}