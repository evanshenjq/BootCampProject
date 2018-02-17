package com.perficient.trainingsystem.controller;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.perficient.trainingsystem.model.Course;
import com.perficient.trainingsystem.model.CourseListResult;
import com.perficient.trainingsystem.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseListControllerTest {
	@Autowired
	CourseListController courseListController;
	@Autowired
	CourseRepository courseRepository;
	
	@Test
	public void testCourseListAsThePageIsLegal() throws Exception{
		List<Course> courses=new ArrayList<Course>();
		CourseListResult result = new CourseListResult(10, 1, courses);
	//	System.out.println("测试"+courseListController.showListCourse(1,"5a3b580bc9e77c0001637312)").getData());
		assertEquals(result.getNowPage(), courseListController.showListCourse(1,"5a3b37d1c9e77c00019ba730").getNowPage());		
	}
	
	@Test
	public void testCourseListAsThePageIsIlLegal() throws Exception{
		List<Course> courses=new ArrayList<Course>();
		CourseListResult result = new CourseListResult(10, 1, courses);
		assertEquals(result.getNowPage(),courseListController.showListCourse(10,"5a3b37d1c9e77c00019ba730").getNowPage());
	}
	
	@Test
	public void delCourse() throws Exception{
		Course course = new Course();
		course.setCourseName("kkk");
		course.setLogo("1513826366145");
		courseRepository.save(course);
		String names = course.getCourseName();
		assertEquals((Integer)0, courseListController.delCourse(names).getCode());
	}
}