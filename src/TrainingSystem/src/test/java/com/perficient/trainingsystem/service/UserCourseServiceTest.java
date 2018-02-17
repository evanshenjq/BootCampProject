package com.perficient.trainingsystem.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCourseServiceTest {
	@Autowired
	UserCourseService userCourseService;
	
	@Test
	public void testAllUserCourseDates() {
		String userId = "5a4d9b1886e4181c459603b1";
		List<String> ls = userCourseService.allUserCourseDates(userId);
		assertEquals(true, ls.size() > 0);
	}

}
