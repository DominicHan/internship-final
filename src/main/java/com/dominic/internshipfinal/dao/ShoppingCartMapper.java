package com.dominic.internshipfinal.dao;

import com.dominic.internshipfinal.domain.entity.Goods;
import com.dominic.internshipfinal.domain.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartMapper {
    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    int getCount(String account);

    List<ShoppingCart> selectByAccount(String account);
}