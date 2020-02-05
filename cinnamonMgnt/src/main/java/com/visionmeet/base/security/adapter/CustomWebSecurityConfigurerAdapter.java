package com.visionmeet.base.security.adapter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
 
import com.visionmeet.base.security.service.CustomUserDetailsService;
 
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    
	private final Log logger = LogFactory.getLog(getClass());
	
	
    @Autowired
    CustomUserDetailsService customUserDetailsService;
 
    @Bean
    public PasswordEncoder passwordEncoder() {
    	
    	logger.info("passwordEncoder:" + new BCryptPasswordEncoder());
    	
      return new BCryptPasswordEncoder();
    }
    
    /*
     * 스프링 시큐리티 룰을 무시하게 하는 Url 규칙.
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
        .antMatchers("/openapi/**");
        
        logger.info("configure web");
    }
    
    /*
     * 스프링 시큐리티 룰.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().formLogin();
        
        logger.info("configure http");
    }
 
    /*
     * 스프링 시큐리티가 사용자를 인증하는 방법이 담긴 객체.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
        
        logger.info("configure auth");
    }
    
}

