package com.dominic.internshipfinal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.dominic.internshipfinal.dao")
public class InternshipFinalApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(InternshipFinalApplication.class, args);
		System.out.println("----------------------------------------\n" +
				           "启动成功\n" +
						   "----------------------------------------\n");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InternshipFinalApplication.class);
	}
}
