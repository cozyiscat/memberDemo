package com.mysite.member.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	
	public User getUser(String username) {
		return userMapper.getUserByUser(username);

	}
	 public List<User> getAllUsers() {
	        return userMapper.getAllUsers(); // 모든 사용자 목록 반환
	    }
	 public void createUser(User user) {
	        userMapper.insertUser(user);
	    }
}
