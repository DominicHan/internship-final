package com.dominic.internshipfinal.dao;

import com.dominic.internshipfinal.domain.entity.MineComments;

public interface MineCommentsMapper {
    int insert(MineComments record);

    int insertSelective(MineComments record);
}