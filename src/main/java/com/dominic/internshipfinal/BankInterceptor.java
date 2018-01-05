package com.dominic.internshipfinal;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;


public class BankInterceptor extends HandlerInterceptorAdapter {

    public BankInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("inter222");
        OutputStream out = response.getOutputStream();
        String data = "{\"code\": \"0\",\"message\": \"serial_no不能为空\",\"data\":\"\"}";
        out.write(data.getBytes());
        //TODO
        //return true走postHandle  false拦截请求
        //return super.preHandle(request, response, handler);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("inter33");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("inter444");
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("inte5555");
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
