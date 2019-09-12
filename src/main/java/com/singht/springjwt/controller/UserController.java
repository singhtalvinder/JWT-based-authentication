package com.singht.springjwt.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singht.springjwt.model.User;
import com.singht.springjwt.security.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/users")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<User>> getAllUsers() {
		
		List<User> users = userService.findAll();
		System.out.println("All Users: total: " + users.size());
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	
	@GetMapping(value="/getuser")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<User> getUser(Principal principal) {
		
		User user = userService.getUserByEmail(principal.getName());
		System.out.println("getUser: user with first name: " + user.getFirstName() + " role: " + user.getRole());
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
