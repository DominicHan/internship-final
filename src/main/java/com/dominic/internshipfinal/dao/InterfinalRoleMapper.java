package com.dominic.internshipfinal.dao;

import com.dominic.internshipfinal.domain.entity.InterfinalRole;

public interface InterfinalRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InterfinalRole record);

    int insertSelective(InterfinalRole record);

    InterfinalRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InterfinalRole record);

    int updateByPrimaryKey(InterfinalRole record);
}