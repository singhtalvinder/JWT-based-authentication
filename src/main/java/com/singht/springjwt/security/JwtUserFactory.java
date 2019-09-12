package com.singht.springjwt.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.singht.springjwt.model.User;

public class JwtUserFactory {

	public static JwtUser create(User user) {
		
		return new JwtUser(
				user.getId(), 
				user.getEmail(),
				user.getPassword(), 
				user,
			 	mapToGrantedAuthorities(new ArrayList<String>(Arrays.asList("ROLE " + user.getRole()))),
				user.isEnabled());
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
		
		return authorities.stream().map(Authority -> new SimpleGrantedAuthority(Authority)).collect(Collectors.toList());
	}

}
