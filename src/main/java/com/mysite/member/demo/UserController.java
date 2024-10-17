package com.mysite.member.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	@GetMapping
	public List<User> getUsers() {

		return userService.getAllUsers();
	}


	
	@GetMapping("/{username}")
	@ResponseBody
	public User getUser(@PathVariable("username") String username, Model model) {
		User user = userService.getUser(username);
		model.addAttribute("user",user);
		return user;
	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user) {
	    userService.createUser(user); // 사용자 추가
	    return ResponseEntity.ok("사용자 추가 성공");
	}
}
