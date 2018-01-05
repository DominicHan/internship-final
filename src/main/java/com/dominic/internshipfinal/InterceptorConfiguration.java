package com.dominic.internshipfinal;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BankInterceptor()).addPathPatterns("/test/get1");
        //registry.addInterceptor(new BankInterceptor()).excludePathPatterns());
        super.addInterceptors(registry);
    }
}
