package com.singht.springjwt.security.service;

import java.util.List;

import com.singht.springjwt.model.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	User getUserByEmail(String email);

}
