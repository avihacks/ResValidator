package com.reqvalidator.ResValidator.controllers;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reqvalidator.ResValidator.model.User;
import com.reqvalidator.ResValidator.model.dtos.UserDto;
import com.reqvalidator.ResValidator.service.UserService;

import jakarta.validation.Valid;

@RequestMapping(value = "/user")
@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
	//	super();
		this.userService = userService;
	}

	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody UserDto userDto) {
	    userDto.printInfo(); // Check the state of userDto

		User user = userService.create(userDto.toUser());
		
		return new ResponseEntity<>(user, HttpStatus.CREATED);
		
	}
	
	
	
}
