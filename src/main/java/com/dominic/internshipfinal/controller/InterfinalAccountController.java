package com.dominic.internshipfinal.controller;

import com.dominic.internshipfinal.comm.aop.LoggerManage;
import com.dominic.internshipfinal.domain.entity.InterfinalAccount;
import com.dominic.internshipfinal.domain.result.ExceptionMsg;
import com.dominic.internshipfinal.domain.result.Response;
import com.dominic.internshipfinal.domain.result.ResponseData;
import com.dominic.internshipfinal.service.InterfinalAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class InterfinalAccountController {
    @Autowired
    InterfinalAccountService interfinalAccountService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping(value = "/test/get1", method = RequestMethod.POST)
    @LoggerManage(description = "属性修改")
    public ResponseData get1(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("id");
        InterfinalAccount interfinalAccount = interfinalAccountService.getAccount(Integer.parseInt(str));
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        vo.set("test", "gthy123");
        System.out.println(vo.get("test"));
        return new ResponseData(ExceptionMsg.SUCCESS, interfinalAccount);
    }

    @RequestMapping(value = "/test/get", method = RequestMethod.GET)
    @LoggerManage(description = "属性修改")
    public ResponseData getAccount(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("id");
        InterfinalAccount interfinalAccount = interfinalAccountService.getAccount(Integer.parseInt(str));
        return new ResponseData(ExceptionMsg.SUCCESS, interfinalAccount);
    }

    /**
     * 注册
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @LoggerManage(description = "注册")
    public Response create(InterfinalAccount account) {
        try {
            InterfinalAccount registUser = interfinalAccountService.getAccountByAccountNo(account.getAccount());
            if (null != registUser) {
                return new Response(ExceptionMsg.AccountUsed);
            } else if (StringUtils.isEmpty(account.getAccount())) {
                return new Response(ExceptionMsg.AccountEmpty);
            } else if (StringUtils.isEmpty(account.getAccountPassword())) {
                return new Response(ExceptionMsg.PassWordEmpty);
            } else if (StringUtils.isEmpty(account.getNick())) {
                return new Response(ExceptionMsg.NickEmpty);
            } else {
                //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                account.setCreateTime(new Date());
                interfinalAccountService.addAccount(account);
            }
        } catch (Exception e) {
            //logger.error("create user failed, ", e);
            return new Response(ExceptionMsg.FAILED);
        }
        return new Response(ExceptionMsg.SUCCESS);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @LoggerManage(description = "登陆")
    public ResponseData login(InterfinalAccount account, HttpServletResponse response) {
        try {
            InterfinalAccount loginAccount = interfinalAccountService.getAccountByAccountNo(account.getAccount());
            if (loginAccount == null) {
                return new ResponseData(ExceptionMsg.LoginNameNotExists);
            } else if (!loginAccount.getAccountPassword().equals(account.getAccountPassword())) {
                return new ResponseData(ExceptionMsg.LoginNameOrPassWordError);
            }  else if (StringUtils.isEmpty(loginAccount.getGesturesPassword())) {
                return new ResponseData(ExceptionMsg.GesturesPasswordEmpty);
            }
            return new ResponseData(ExceptionMsg.SUCCESS);
        } catch (Exception e) {
            //logger.error("login failed, ", e);
            return new ResponseData(ExceptionMsg.FAILED);
        }
    }

    @RequestMapping(value = "/setGestures", method = RequestMethod.POST)
    @LoggerManage(description = "设置手势密码")
    public Response setGestures(InterfinalAccount account) {
        try {
            InterfinalAccount loginAccount = interfinalAccountService.getAccountByAccountNo(account.getAccount());
            if (loginAccount == null) {
                return new Response(ExceptionMsg.LoginNameNotExists);
            }
            loginAccount.setGesturesPassword(account.getGesturesPassword());
            interfinalAccountService.setGestures(loginAccount);
        } catch (Exception e) {
            return new Response(ExceptionMsg.FAILED);
        }
        return new Response(ExceptionMsg.SUCCESS);
    }

    @RequestMapping(value = "/checkGestures", method = RequestMethod.POST)
    @LoggerManage(description = "校验手势密码")
    public Response checkGestures(InterfinalAccount account) {
        try {
            InterfinalAccount loginAccount = interfinalAccountService.getAccountByAccountNo(account.getAccount());
            if (loginAccount == null) {
                return new Response(ExceptionMsg.LoginNameNotExists);
            } else if (!account.getGesturesPassword().equals(loginAccount.getGesturesPassword())) {
                return new Response(ExceptionMsg.GesturesPasswordError);
            } else {
                return new Response(ExceptionMsg.SUCCESS);
            }
        } catch (Exception e) {
            return new Response(ExceptionMsg.FAILED);
        }
    }
}
