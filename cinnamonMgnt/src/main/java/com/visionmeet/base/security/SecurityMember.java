package com.visionmeet.base.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.userdetails.User;

public class SecurityMember extends User{
 
    private static final long serialVersionUID = 1L;
    
    private String ip;
    
    private final Log logger = LogFactory.getLog(getClass());
    
    public SecurityMember(Member member) {
        super(member.getUser_id(), member.getPassword(), member.getAuthorities());
    }
 
    public String getIp() {
    	logger.info("getIp:" + ip);
        return ip;
    }
 
    public void setIp(String ip) {
    	logger.info("ip:" + ip);
        this.ip = ip;
    }
 
}
