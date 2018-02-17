package com.perficient.trainingsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.perficient.trainingsystem.model.Result;
import com.perficient.trainingsystem.model.User;
import com.perficient.trainingsystem.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/loginUser",method={ RequestMethod.POST})
	@ResponseBody
	public Result<User> loginUser(String username,String password) {
		User user=userService.loginUser(username, password);
		if(user != null) {
			Result<User> result=new Result<User>(101,"login success");
			result.setData(user);
			return result;
		}
		

		return new Result(200,"please input right username and password");
		
	}
}
