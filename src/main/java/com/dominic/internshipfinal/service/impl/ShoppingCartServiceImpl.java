package com.dominic.internshipfinal.service.impl;

import com.dominic.internshipfinal.dao.GoodsMapper;
import com.dominic.internshipfinal.dao.ShoppingCartMapper;
import com.dominic.internshipfinal.domain.entity.Goods;
import com.dominic.internshipfinal.domain.entity.ShoppingCart;
import com.dominic.internshipfinal.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @Override
    public void addToShoppingCart(String account, int goodsId) {
        ShoppingCart sc = new ShoppingCart();
        sc.setAccountId(account);
        sc.setGoodsId(goodsId);
        shoppingCartMapper.insertSelective(sc);
    }

    @Override
    public List<ShoppingCart> getShoppingCart(String account) {
        return shoppingCartMapper.selectByAccount(account);
    }

    @Override
    public int getCount(String account) {
        return shoppingCartMapper.getCount(account);
    }

    @Override
    public Goods getGoodsById(int id) {
        return goodsMapper.selectByPrimaryKey(id);
    }
}
