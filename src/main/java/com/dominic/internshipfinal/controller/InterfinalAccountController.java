package com.dominic.internshipfinal.controller;

import com.dominic.internshipfinal.entity.InterfinalAccount;
import com.dominic.internshipfinal.service.InterfinalAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/service/general/tp-cashier")
public class InterfinalAccountController {
    @Autowired
    InterfinalAccountService interfinalAccountService;

    @RequestMapping("/get")
    @ResponseBody
    public String getAccount(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("id");
        InterfinalAccount interfinalAccount = interfinalAccountService.getAccount(Integer.parseInt(str));
        return interfinalAccount.toString();
    }
}
