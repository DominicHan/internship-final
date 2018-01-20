package com.dominic.internshipfinal.controller;

import com.dominic.internshipfinal.comm.aop.LoggerManage;
import com.dominic.internshipfinal.domain.BrandAndModel;
import com.dominic.internshipfinal.domain.entity.Goods;
import com.dominic.internshipfinal.domain.entity.InterfinalAccount;
import com.dominic.internshipfinal.domain.result.ExceptionMsg;
import com.dominic.internshipfinal.domain.result.ResponseData;
import com.dominic.internshipfinal.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClassificationController {

    @Autowired
    ClassificationService classificationService;

    @RequestMapping(value = "/main/classification", method = RequestMethod.POST)
    @LoggerManage(description = "分类查询商品")
    public ResponseData classification(HttpServletRequest request) {
        //String str = request.getParameter("clothesLength");
        Map<String, String[]> map = request.getParameterMap();
/*        System.out.println(map);
        System.out.println(map.get("clothes_length"));*/
        Map map1 = new HashMap();
        for(Map.Entry<String, String[]> entry :map.entrySet()){
            String paramName = entry.getKey();
            String paramValue = "";
            String[] paramValueArr = entry.getValue();
            for (int i = 0; paramValueArr!=null && i < paramValueArr.length; i++) {
                if (i == paramValueArr.length-1) {
                    paramValue+=paramValueArr[i];
                }else {
                    paramValue+=paramValueArr[i]+",";
                }
            }
            if (paramName.equals("prices") && !StringUtils.isEmpty(paramValue)) {
                String[] price = paramValue.split("-");
                map1.put("lowPrices", price[0]);
                map1.put("highPrices", price[1]);
            }
            map1.put(paramName, paramValue);
            if (paramName.equals("composite")) {
                if (paramValue.equals("综合排序")) {
                    map1.put("comp", "综合排序");
                } else if (paramValue.equals("销量优先")) {
                    map1.put("salesVolume", "销量优先");
                } else if (paramValue.equals("评论数从高到低")) {
                    map1.put("commentNumber", "评论数从高到低");
                } else if (paramValue.equals("新品")) {
                    map1.put("newProduct", "新品");
                }
            }
            System.out.println(paramName + paramValue);
        }
        List<Goods> goods = classificationService.getGoods(map1);
        return new ResponseData(ExceptionMsg.SUCCESS, goods);
    }


    @RequestMapping(value = "/main/getBrand", method = RequestMethod.POST)
    @LoggerManage(description = "获取品牌")
    public ResponseData getBrand(HttpServletRequest request, HttpServletResponse response) {
        List<String> brands = classificationService.getBrand();
        return new ResponseData(ExceptionMsg.SUCCESS, brands);
    }

    @RequestMapping(value = "/main/getModel", method = RequestMethod.POST)
    @LoggerManage(description = "获取领型")
    public ResponseData getModel(HttpServletRequest request, HttpServletResponse response) {
        List<String> models = classificationService.getModel();
        return new ResponseData(ExceptionMsg.SUCCESS, models);
    }

    @RequestMapping(value = "/main/getBrandAndModel", method = RequestMethod.POST)
    @LoggerManage(description = "获取品牌和领型")
    public ResponseData getBrandAndModel(HttpServletRequest request, HttpServletResponse response) {
        List<String> brands = classificationService.getBrand();
        List<String> models = classificationService.getModel();
        BrandAndModel brandAndModel = new BrandAndModel();
        brandAndModel.setBrandList(brands);
        brandAndModel.setGetModelList(models);
        return new ResponseData(ExceptionMsg.SUCCESS, brandAndModel);
    }
}
