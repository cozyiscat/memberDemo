package com.mysite.member.demo;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
	 User getUserByUser(String username);
	List<User> getAllUsers();
	void insertUser(User user);
}
