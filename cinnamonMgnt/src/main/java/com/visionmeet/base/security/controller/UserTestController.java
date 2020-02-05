package com.visionmeet.base.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.visionmeet.base.security.Member;
import com.visionmeet.base.security.UserMapper;
 
@Controller
public class UserTestController {
 
    @Autowired
    UserMapper userMapper;
    
    @RequestMapping("/openapi/readUser/{username}")
    public @ResponseBody String  openApiReadUser(@PathVariable String username) {
        Member member = userMapper.readUser(username);
        //return member.getName();
        return member.getUser_id();
    }
    
    @RequestMapping("/openapi/readAuthority/{username}")
    public @ResponseBody String  openApiReadAuthority(@PathVariable String username) {
        List<String> auths = userMapper.readAuthority(username);
        
        StringBuffer buf = new StringBuffer();
        for(String auth : auths) {
            buf.append(auth);
            buf.append(" ");
        }
        return buf.toString();
    }
}
