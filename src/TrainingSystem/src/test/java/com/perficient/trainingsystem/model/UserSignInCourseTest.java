package com.perficient.trainingsystem.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserSignInCourseTest {

	@Test
	public void test() {
		UserSignInCourse usic = new UserSignInCourse();
		usic.setCourseId("5a557622c9e77c0001de3661");
		usic.setUserId("5a4d9b1886e4181c459603b1");
		usic.setCourseTime("2018-01-09");
		usic.getCourseId();
		usic.getCourseTime();
		usic.getUserId();
		usic.equals(usic);
		usic.toString();		
	}

}
