package com.dominic.internshipfinal.service;

import com.dominic.internshipfinal.domain.entity.Goods;
import com.dominic.internshipfinal.domain.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    // 添加到购物车
    void addToShoppingCart(String account, int goodsId);
    // 获取购物车数据
    List<ShoppingCart> getShoppingCart(String account);
    // 获取此用户购物车内数据数量
    int getCount(String account);
    // 根据商品id获取商品信息
    Goods getGoodsById(int id);
}
