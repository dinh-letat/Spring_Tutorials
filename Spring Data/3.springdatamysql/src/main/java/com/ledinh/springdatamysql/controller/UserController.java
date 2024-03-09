package com.ledinh.springdatamysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ledinh.springdatamysql.entity.User;
import com.ledinh.springdatamysql.repository.UserRepoitory;

@Controller
@RequestMapping("/demo")
public class UserController {
	@Autowired
	private UserRepoitory userRepository;
	
	@PostMapping("/add")
	public @ResponseBody String addUser(@RequestParam String name, @RequestParam String email) {
		User user = new User();
		user.setUsername(name);
		user.setEmail(email);
		userRepository.save(user);
		return "saved!!";
	}
	
	@GetMapping("/users")
	public @ResponseBody Iterable<User> getAllUser(){
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}
