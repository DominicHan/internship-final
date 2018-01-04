package com.dominic.internshipfinal.dao;

import com.dominic.internshipfinal.domain.entity.MinePraise;

public interface MinePraiseMapper {
    int insert(MinePraise record);

    int insertSelective(MinePraise record);
}