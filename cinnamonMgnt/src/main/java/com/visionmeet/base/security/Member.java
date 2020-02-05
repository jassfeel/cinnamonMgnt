package com.visionmeet.base.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
	
public class Member {
 
	private String user_id;
	
	private String company_code;
    
    private String password;
    
    private String name;
    
    private boolean isAccountNonExpired;
    
    private boolean isAccountNonLocked;
    
    private boolean isCredentialsNonExpired;
    
    private boolean isEnabled;
    
    private Collection<? extends GrantedAuthority> authorities;
    	
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }
 
    public void setAccountNonExpired(boolean isAccountNonExpired) {
        this.isAccountNonExpired = isAccountNonExpired;
    }
 
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }
 
    public void setAccountNonLocked(boolean isAccountNonLocked) {
        this.isAccountNonLocked = isAccountNonLocked;
    }
 
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }
 
    public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
        this.isCredentialsNonExpired = isCredentialsNonExpired;
    }
 
    public boolean isEnabled() {
        return isEnabled;
    }
 
    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
    
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
 
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCompany_code() {
		return company_code;
	}

	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}


}
