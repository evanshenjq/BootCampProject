package com.perficient.trainingsystem.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseTest {

	@Test
	public void test() {
		Course course = new Course();
		course.setClassHouers("1");
		course.setCompanyId("12345");
		course.setCourseName("English");
		course.setDescription("This is an English class for you!");
		course.setTeacher("Mia");
		course.setSuitableCrowd("students");
		course.setId("12");
		course.setType("one to one");
		course.setPrice("120");
		course.setLogo("1274392847857465");
		course.setTime("2018");
		course.getClassHouers();
		course.getCompanyId();
		course.getCourseName();
		course.getDescription();
		course.getTeacher();
		course.getSuitableCrowd();
		course.getId();
		course.getType();
		course.getPrice();
		course.getLogo();
		course.getTime();
		course.toString();
	}

}
