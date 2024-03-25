package com.dinhle.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinhle.user.model.User;
import com.dinhle.user.repository.UserRepository;
import com.dinhle.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@GetMapping("")
//	public List<User> getAllUser(){
//		return userService.findAll();
//	}
	
	@PostMapping("")
	public void addUser( ) {
		userService.addUser(null, null, null);
	}
}
