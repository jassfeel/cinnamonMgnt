package com.visionmeet.base.security;

import java.util.Collection;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

@Mapper
public interface UserMapper  {
 
	Collection<GrantedAuthority> getAuthorities(String username);
	
    public Member readUser(String user_id);
 
    public List<String> readAuthority(String user_id);
    
    public void createUser(Member member);
    public void deleteUser(String username);
    
}
