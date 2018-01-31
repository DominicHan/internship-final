package com.dominic.internshipfinal.controller.rest;

import com.dominic.internshipfinal.comm.aop.LoggerManage;
import com.dominic.internshipfinal.domain.entity.Goods;
import com.dominic.internshipfinal.domain.entity.ShoppingCart;
import com.dominic.internshipfinal.domain.result.ExceptionMsg;
import com.dominic.internshipfinal.domain.result.Response;
import com.dominic.internshipfinal.domain.result.ResponseData;
import com.dominic.internshipfinal.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/shoppingCart/add", method = RequestMethod.POST)
    @LoggerManage(description = "添加到购物车")
    public Response addToShoppingCart(HttpServletRequest request, HttpServletResponse response) {
        try {
            String account = request.getParameter("account");
            String goodsId = request.getParameter("goodsId");
            int count = shoppingCartService.getCount(account);
            if (count > 10) {
                return new Response(ExceptionMsg.TooManyGoods);
            }
            shoppingCartService.addToShoppingCart(account, Integer.parseInt(goodsId));
        } catch (Exception e) {
            //logger.error("create user failed, ", e);
            return new Response(ExceptionMsg.FAILED);
        }
        return new Response(ExceptionMsg.SUCCESS);
    }

    @RequestMapping(value = "/shoppingCart/get", method = RequestMethod.POST)
    @LoggerManage(description = "获取购物车数据")
    public ResponseData getShoppingCart(HttpServletRequest request, HttpServletResponse response) {
        try {
            String account = request.getParameter("account");
            //String goodsId = request.getParameter("goodsId");
            List<ShoppingCart> cartList = shoppingCartService.getShoppingCart(account);
            List<Goods> goodsList = new ArrayList<Goods>();
            for(ShoppingCart carts : cartList) {
                goodsList.add(shoppingCartService.getGoodsById(carts.getGoodsId()));
            }
            return new ResponseData(ExceptionMsg.SUCCESS, goodsList);
        } catch (Exception e) {
            //logger.error("create user failed, ", e);
            return new ResponseData(ExceptionMsg.FAILED);
        }
    }
}
