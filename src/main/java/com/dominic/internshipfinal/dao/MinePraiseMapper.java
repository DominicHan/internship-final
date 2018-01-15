package com.dominic.internshipfinal.dao;

import com.dominic.internshipfinal.domain.entity.MinePraise;

import java.util.List;

public interface MinePraiseMapper {
    int insert(MinePraise record);

    int insertSelective(MinePraise record);

    List<MinePraise> selectById(int id);

    MinePraise selectByIdAccount(MinePraise minePraise);
}