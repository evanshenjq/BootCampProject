package com.perficient.trainingsystem.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCourseTest {

	@Test
	public void test() {
		UserCourse uc = new UserCourse();
		uc.setCourseId("5a557622c9e77c0001de3661");
		uc.setUserId("5a4d9b1886e4181c459603b1");
		uc.setId("5a58281ec9e77c0001571c08");
		uc.getCourseId();
		uc.getId();
		uc.getUserId();
		uc.equals(uc);
		uc.toString();
	}

}
