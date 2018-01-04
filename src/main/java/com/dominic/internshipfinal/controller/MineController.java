package com.dominic.internshipfinal.controller;

import com.dominic.internshipfinal.comm.aop.LoggerManage;
import com.dominic.internshipfinal.domain.result.ExceptionMsg;
import com.dominic.internshipfinal.domain.result.Response;
import com.dominic.internshipfinal.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MineController {

    @Autowired
    MineService mineService;

    @RequestMapping(value = "/mine/setPraise", method = RequestMethod.POST)
    @LoggerManage(description = "给消息点赞")
    public Response setPraise(HttpServletRequest request) {
        try {
            String mineInfoId = request.getParameter("id");
            String account = request.getParameter("account");
            mineService.setPraise(Integer.parseInt(mineInfoId), account);
            return new Response(ExceptionMsg.SUCCESS);
        } catch (Exception e) {
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
}
