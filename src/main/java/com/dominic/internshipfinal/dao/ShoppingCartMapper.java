package com.dominic.internshipfinal.dao;

import com.dominic.internshipfinal.domain.entity.ShoppingCart;

public interface ShoppingCartMapper {
    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);
}