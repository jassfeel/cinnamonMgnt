package com.visionmeet.base.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfig implements WebMvcConfigurer {
	private final Log logger = LogFactory.getLog(getClass());
	
	public void addViewControllers(ViewControllerRegistry registry) {
		
		logger.info("MvcConfig");
		//registry.addViewController("/home").setViewName("home");
		//registry.addViewController("/").setViewName("thymeleaf/openList"); // 초기화면 
		//registry.addViewController("/hello").setViewName("hello");
		//registry.addViewController("/login").setViewName("login");
	}

}
