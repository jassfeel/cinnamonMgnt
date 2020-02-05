package com.visionmeet.base.security.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.visionmeet.base.security.Member;
import com.visionmeet.base.security.SecurityMember;
import com.visionmeet.base.security.UserMapper;
 
@Service
public class CustomUserDetailsService implements UserDetailsService{
    
    private static final String ROLE_PREFIX = "ROLE_";
    
    private final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    UserMapper userMapper;
 
    @Override
    public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
        
        Member member = userMapper.readUser(user_id);
       
        if(member != null) {
        	logger.info("member:"+ member);
            member.setAuthorities(makeGrantedAuthority(userMapper.readAuthority(user_id)));

        }
        logger.info("SecurityMember:"+ member);
        return new SecurityMember(member);
    }
    
    public void createUser(Member member) {
         String rawPassword = member.getPassword();
         String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
         member.setPassword(encodedPassword);
         userMapper.createUser(member);
         //userMapper.createAuthority(member);
    }
    
    /*
    @Override
    public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
        
    	//HttpSession session = null;
    	//HttpSession httpSession = request.getSession(true);
        Member member = userMapper.readUser(user_id);
        
        
        
        if(member != null) {
        	logger.info("member:"+ member);
            member.setAuthorities(makeGrantedAuthority(userMapper.readAuthority(user_id)));
            
           // session.setAttribute("user_id", member.getUser_id());
            //session.setAttribute("auth", member.getAuthorities());

        }
        logger.info("SecurityMember:"+ member);
        return new SecurityMember(member);
    }
    */
    
    private static List<GrantedAuthority> makeGrantedAuthority(List<String> roles){
        List<GrantedAuthority> list = new ArrayList<>();
        roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role)));
        System.out.println("list:" + list);
        return list;
        
    }
 
 
}
