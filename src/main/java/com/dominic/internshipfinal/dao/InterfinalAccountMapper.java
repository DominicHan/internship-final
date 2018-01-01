package com.dominic.internshipfinal.dao;

import com.dominic.internshipfinal.domain.entity.InterfinalAccount;

public interface InterfinalAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InterfinalAccount record);

    int insertSelective(InterfinalAccount record);

    InterfinalAccount selectByPrimaryKey(Integer id);

    InterfinalAccount selectByAccountNo(String account);

    int updateByPrimaryKeySelective(InterfinalAccount record);

    int updateByPrimaryKey(InterfinalAccount record);
}