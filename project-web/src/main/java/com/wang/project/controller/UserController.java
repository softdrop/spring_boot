package com.wang.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wang.project.entity.User;
import com.wang.project.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/info")
	public User getUserInfoByAccount(String account) {
		return new User() {{setAccount("wang");setName("wyw");}};
	}
	
	@RequestMapping("/all.user")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
}
