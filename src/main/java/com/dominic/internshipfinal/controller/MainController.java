package com.dominic.internshipfinal.controller;

import com.dominic.internshipfinal.comm.aop.LoggerManage;
import com.dominic.internshipfinal.domain.BusinessAffairs;
import com.dominic.internshipfinal.domain.entity.GoodsType1;
import com.dominic.internshipfinal.domain.entity.InterfinalBanner;
import com.dominic.internshipfinal.domain.result.ExceptionMsg;
import com.dominic.internshipfinal.domain.result.ResponseData;
import com.dominic.internshipfinal.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    MainService mainService;

    @RequestMapping(value = "/main/businessAffairs", method = RequestMethod.GET)
    @LoggerManage(description = "首页商务数据")
    public ResponseData businessAffairs() {
        List<InterfinalBanner> banners = mainService.getBanners();
        List<GoodsType1> goods_type = mainService.getGoodsType1();
        return new ResponseData(ExceptionMsg.SUCCESS, new BusinessAffairs(banners, goods_type));
    }

    @RequestMapping(value = "/main/supermarket", method = RequestMethod.GET)
    @LoggerManage(description = "首页超市数据")
    public ResponseData supermarket() {
        List<InterfinalBanner> banners = mainService.getBanners();
        List<GoodsType1> goods_type = mainService.getGoodsType1();
        return new ResponseData(ExceptionMsg.SUCCESS, new BusinessAffairs(banners, goods_type));
    }

}
