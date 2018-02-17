package com.perficient.trainingsystem.modal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.perficient.trainingsystem.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	
	@Test
	public void test() {
		User user = new User();
		user.setId("123456");
		user.setPassword("123456");
		user.setRole("123");
		user.setUsername("hello");
		user.setUserId("123");
		user.getPassword();
		user.getRole();
		user.getUserId();
		user.getUsername();
		user.getId();
	}

}
