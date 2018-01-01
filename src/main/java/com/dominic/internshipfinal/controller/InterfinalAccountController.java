package com.dominic.internshipfinal.controller;

import com.dominic.internshipfinal.comm.aop.LoggerManage;
import com.dominic.internshipfinal.domain.entity.InterfinalAccount;
import com.dominic.internshipfinal.domain.result.ExceptionMsg;
import com.dominic.internshipfinal.domain.result.Response;
import com.dominic.internshipfinal.domain.result.ResponseData;
import com.dominic.internshipfinal.service.InterfinalAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class InterfinalAccountController {
    @Autowired
    InterfinalAccountService interfinalAccountService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @LoggerManage(description="属性修改")
    public ResponseData getAccount(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("id");
        InterfinalAccount interfinalAccount = interfinalAccountService.getAccount(Integer.parseInt(str));
        return new ResponseData(ExceptionMsg.SUCCESS, interfinalAccount);
    }

    /**
     * 注册
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @LoggerManage(description="注册")
    public Response create(InterfinalAccount account) {
        try {
            InterfinalAccount registUser = interfinalAccountService.getAccountByAccountNo(account.getAccount());
            if (null != registUser) {
                return new Response(ExceptionMsg.AccountUsed);
            } else {
                interfinalAccountService.addAccount(account);
            }
        } catch (Exception e) {
            //logger.error("create user failed, ", e);
            return new Response(ExceptionMsg.FAILED);
        }
        return new Response(ExceptionMsg.SUCCESS);
    }

}
