package com.reqvalidator.ResValidator.service;

import java.util.List;
import java.util.Optional;

import com.reqvalidator.ResValidator.model.User;

public interface UserService {

	 User create(User user);

	  List<User> findAll();

	  Optional<User> findById(int id);
}
