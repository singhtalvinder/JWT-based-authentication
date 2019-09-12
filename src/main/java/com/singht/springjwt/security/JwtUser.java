package com.singht.springjwt.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.singht.springjwt.model.User;

public class JwtUser implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = -20315245410162687L;
	
	
	private final Long id;
	private final String username;
	private final String password;
	private final User user;
	
	private final Collection<? extends GrantedAuthority> authorities;
	private final boolean enabled;
	public JwtUser(Long id, String username, String password, User user,
			Collection<? extends GrantedAuthority> authorities, boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.user = user;
		this.authorities = authorities;
		this.enabled = enabled;
	}
	
	@JsonIgnore // no need to send data to frontend.
	public Long getId() {
		return id;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	public User getUser() {
		return user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	@JsonIgnore // no need to send data to frontend.
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@JsonIgnore // no need to send data to frontend.
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@JsonIgnore // no need to send data to frontend.
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	

}
