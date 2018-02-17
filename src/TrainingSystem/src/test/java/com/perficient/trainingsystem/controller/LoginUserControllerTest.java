package com.perficient.trainingsystem.controller;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.perficient.trainingsystem.model.Result;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginUserControllerTest {
	
	@Autowired
	UserController userController;
	
	private MockMultipartHttpServletRequest request;
	

	@Test
	public void testLoginUserTrue() {
		
		Result result=new Result(101,"login success");	
		
		assertEquals(result.getCode(),userController.loginUser("admin", "123456").getCode());
		
		
	}
	
	@Test
	public void testLoginUserWrong() {

		Result result=new Result(200,"please input right username and password");	
		
		assertEquals(result.getCode(),userController.loginUser("admin", "1111").getCode());
		
	}
}
