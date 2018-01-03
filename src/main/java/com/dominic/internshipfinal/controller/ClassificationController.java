package com.dominic.internshipfinal.controller;

import com.dominic.internshipfinal.comm.aop.LoggerManage;
import com.dominic.internshipfinal.domain.entity.Goods;
import com.dominic.internshipfinal.domain.result.ExceptionMsg;
import com.dominic.internshipfinal.domain.result.ResponseData;
import com.dominic.internshipfinal.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
            if (paramName.equals("prices")) {
                String[] price = paramValue.split("-");
                map1.put("lowPrices", price[0]);
                map1.put("highPrices", price[1]);
            }
            map1.put(paramName, paramValue);
            System.out.println(paramName + paramValue);
        }
        List<Goods> goods = classificationService.getGoods(map1);
        return new ResponseData(ExceptionMsg.SUCCESS, goods);
    }
}
