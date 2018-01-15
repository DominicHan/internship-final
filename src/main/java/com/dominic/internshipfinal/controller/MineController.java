package com.dominic.internshipfinal.controller;

import com.dominic.internshipfinal.comm.aop.LoggerManage;
import com.dominic.internshipfinal.domain.MineInfo;
import com.dominic.internshipfinal.domain.entity.Mine;
import com.dominic.internshipfinal.domain.entity.MinePraise;
import com.dominic.internshipfinal.domain.result.ExceptionMsg;
import com.dominic.internshipfinal.domain.result.Response;
import com.dominic.internshipfinal.domain.result.ResponseData;
import com.dominic.internshipfinal.service.InterfinalAccountService;
import com.dominic.internshipfinal.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MineController {

    @Autowired
    MineService mineService;

    @Autowired
    InterfinalAccountService interfinalAccountService;

    @RequestMapping(value = "/mine/setPraise", method = RequestMethod.POST)
    @LoggerManage(description = "给消息点赞")
    public Response setPraise(HttpServletRequest request) {
        try {
            String mineInfoId = request.getParameter("id");
            String account = request.getParameter("account");
            // 根据id查询是否存在消息
            if (mineService.getMineById(Integer.parseInt(mineInfoId)) == null) {
                return new Response(ExceptionMsg.MineInfoEmpty);
            }
            // 根据account查询是否存在账号
            if (interfinalAccountService.getAccountByAccountNo(account) == null) {
                return new Response(ExceptionMsg.AccountInfoEmpty);
            }
            // 查询此条消息是否已经点赞
            MinePraise minePraise = new MinePraise(Integer.parseInt(mineInfoId), account);
            if (mineService.checkPraise(minePraise) != null) {
                return new Response(ExceptionMsg.AccountAlreadyPraise);
            }
            // 插入点赞表
            mineService.setPraise(Integer.parseInt(mineInfoId), account);
            // 获取点赞账号的昵称信息并返回
            List<String> nickList = new ArrayList<>();
            List<MinePraise> minePraiseList = mineService.getPraise(Integer.parseInt(mineInfoId));
            for (MinePraise minelist : minePraiseList) {
                nickList.add(mineService.getNick(minelist.getAccount()));
            }
            return new ResponseData(ExceptionMsg.SUCCESS, nickList);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(ExceptionMsg.FAILED);
        }
    }


    @RequestMapping(value = "/mine/setComments", method = RequestMethod.POST)
    @LoggerManage(description = "评论消息")
    public Response setComments(HttpServletRequest request) {
        try {
            String mineInfoId = request.getParameter("id");
            String account = request.getParameter("account");
            String content = request.getParameter("content");
            mineService.setComments(Integer.parseInt(mineInfoId), account, content);
            return new Response(ExceptionMsg.SUCCESS);
        } catch (Exception e) {
            return new Response(ExceptionMsg.FAILED);
        }
    }

    @RequestMapping(value = "/mine/getMineInfo", method = RequestMethod.POST)
    @LoggerManage(description = "消息列表")
    public ResponseData getMineInfo(HttpServletRequest request) {
        List<Mine> mines = mineService.mineMapper();
        return new ResponseData(ExceptionMsg.SUCCESS, mines);
    }
}
