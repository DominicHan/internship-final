package com.dominic.internshipfinal.controller;

import com.alibaba.fastjson.JSONObject;
import com.dominic.internshipfinal.comm.aop.LoggerManage;
import com.dominic.internshipfinal.domain.entity.InterfinalAccount;
import com.dominic.internshipfinal.domain.result.ExceptionMsg;
import com.dominic.internshipfinal.domain.result.Response;
import com.dominic.internshipfinal.domain.result.ResponseData;
import com.dominic.internshipfinal.service.InterfinalAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
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

    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<InterfinalAccount> users=interfinalAccountService.getUserList();
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(InterfinalAccount user) {
        interfinalAccountService.addAccount(user);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,int id) {
        InterfinalAccount user=interfinalAccountService.getAccount(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

//    @RequestMapping("/edit")
//    public String edit(InterfinalAccount user) {
//        interfinalAccountService.edit(user);
//        return "redirect:/list";
//    }
//
//
//    @RequestMapping("/delete")
//    public String delete(Long id) {
//        interfinalAccountService.delete(id);
//        return "redirect:/list";
//    }

    /**
     * 注册
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @LoggerManage(description = "注册")
    public Response create(InterfinalAccount account) {
//        Map map = new HashMap();
//        float c = 10.00f;
//        double d = 10.00;
//        map.put("a", "asd");
//        map.put("b", "中文zxc阿斯123顿发生发的发发");
//        map.put("c", c);
//        map.put("d", d);
//
//        //net.sf.json.JSONObject 将Map转换为JSON方法
//        //JSONUtils.toJSONString(requestMap);
//
//        //org.json.JSONObject 将Map转换为JSON方法
//        JSONObject json =new JSONObject(map);
//        System.out.println(json);
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
