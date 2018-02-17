package com.perficient.trainingsystem.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perficient.trainingsystem.model.User;
import com.perficient.trainingsystem.repository.UserRepository;
import com.perficient.trainingsystem.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	@Resource(name="user")
	UserRepository userRepository;

	
	public User loginUser(String username, String password) {
		User user=userRepository.findUserByNameAndPwd(username, password);
		return user;
	}



	
}
