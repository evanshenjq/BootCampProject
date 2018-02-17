package com.perficient.trainingsystem.controller;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.perficient.trainingsystem.model.Course;
import com.perficient.trainingsystem.service.impl.UserCourseServiceImpl;
import com.perficient.trainingsystem.utils.DateUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCourseControllerTest {
	@Autowired
	UserCourseController userCourseController;
	@Autowired
	UserCourseServiceImpl ucs;
	private MockMultipartHttpServletRequest request=new MockMultipartHttpServletRequest();
	
	@Before
	public void SetupContext() {
		request.setMethod("GET");
	}
	@Test
	public void testFindUserSignedCourse() {
		request.setRequestURI("user/signedInLessons");
		
		//test existed sign in
		String userId = "5a4d9b1886e4181c459603b1";
		List<Course> cs = userCourseController.findUserSignedCourse(userId);
		assertEquals(false, cs.isEmpty());
		
		//test if sorted
		for(int i=0; i<cs.size()-1; i++) {
			String d = cs.get(i).getCourseStartTime();
			d = d.substring(0, 10) + d.substring(14);
			Date da1 = DateUtils.stringToDate(d, DateUtils.patternB);
			d = cs.get(i+1).getCourseStartTime();
			d = d.substring(0, 10) + d.substring(14);
			Date da2 = DateUtils.stringToDate(d, DateUtils.patternB);
			assertEquals(true, da1.getTime() >= da2.getTime());
		}
		
		//test no course signed in
		userId = "5a56c37680d3de11e4f90646";
		cs = userCourseController.findUserSignedCourse(userId);
		assertEquals(null, cs);
	}
	
	@Test
	public void testfindCourseByUserId() {
		String userId = "5a4d9b1886e4181c459603b1";
		userCourseController.findCourseByUserId(userId);
	}
	
	@Test
	public void testreserveCourseByUserIdAndCourseId() throws ParseException {
		String userId = "5a4d9b1886e4181c459603b1";
		String courseId_one = "5a557622c9e77c0001de3661";
		String courseId_two="5a5586abbe723b6afd12552a";
		String courseId_three="5a4352ae6cd28541036a3990";
		userCourseController.reserveCourseByUserIdAndCourseId(userId, courseId_one);
		userCourseController.reserveCourseByUserIdAndCourseId(userId, courseId_two);
		userCourseController.reserveCourseByUserIdAndCourseId(userId, courseId_three);
	}

}