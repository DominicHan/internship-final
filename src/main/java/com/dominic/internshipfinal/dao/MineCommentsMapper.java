package com.dominic.internshipfinal.dao;

import com.dominic.internshipfinal.domain.entity.MineComments;

import java.util.List;

public interface MineCommentsMapper {
    int insert(MineComments record);

    int insertSelective(MineComments record);

    List<MineComments> selectById(int id);
}