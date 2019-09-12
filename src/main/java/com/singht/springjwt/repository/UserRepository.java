package com.singht.springjwt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.singht.springjwt.model.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Long>{

	User findByEmailIgnoreCase(String username);

}
