package com.dominic.internshipfinal.controller;

import com.dominic.internshipfinal.comm.aop.LoggerManage;
import com.dominic.internshipfinal.domain.BusinessAffairs;
import com.dominic.internshipfinal.domain.Supermarket;
import com.dominic.internshipfinal.domain.entity.Goods;
import com.dominic.internshipfinal.domain.entity.GoodsType1;
import com.dominic.internshipfinal.domain.entity.GoodsType2;
import com.dominic.internshipfinal.domain.entity.InterfinalBanner;
import com.dominic.internshipfinal.domain.result.ExceptionMsg;
import com.dominic.internshipfinal.domain.result.ResponseData;
import com.dominic.internshipfinal.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    MainService mainService;

    @RequestMapping(value = "/main/businessAffairs", method = RequestMethod.POST)
    @LoggerManage(description = "首页商务数据")
    public ResponseData businessAffairs() {
        List<InterfinalBanner> banners = mainService.getBanners();
        List<GoodsType1> goods_type = mainService.getGoodsType1();
        return new ResponseData(ExceptionMsg.SUCCESS, new BusinessAffairs(banners, goods_type));
    }

    @RequestMapping(value = "/main/supermarket", method = RequestMethod.POST)
    @LoggerManage(description = "首页超市数据")
    public ResponseData supermarket() {
        Supermarket supermarket = new Supermarket();
        supermarket.setTitlePic("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514954557562&di=5baa3318ef880813537f2fa7291cb017&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01acaf5722af116ac7253812b32635.jpg");
        List<Goods> goods = mainService.getGoods();
        List<String> types = mainService.getGoodsType2();
        List<Supermarket.GoodsList> lists = new ArrayList<Supermarket.GoodsList>();
        for (String attribute: types) {
            Supermarket.GoodsList list = new Supermarket.GoodsList();
            List<Goods> good = new ArrayList<>();
            list.setTypeName(attribute);
            for (Goods attribute1: goods) {
                if (attribute.equals(attribute1.getType())) {
                    good.add(attribute1);
                }
            }
            list.setList(good);
            lists.add(list);
        }
        supermarket.setTypeList(types);
        supermarket.setGoodsList(lists);
        return new ResponseData(ExceptionMsg.SUCCESS, supermarket);
    }
}
