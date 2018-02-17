package com.perficient.trainingsystem.controller;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import com.perficient.trainingsystem.exception.CourseException;
import com.perficient.trainingsystem.model.Course;
import com.perficient.trainingsystem.model.Result;
import com.perficient.trainingsystem.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseAddControllerTest {
	
	private MultipartFile multipartFile1;
	private MockMultipartHttpServletRequest request=new MockMultipartHttpServletRequest();
	
	@Autowired
	private CourseController courseAddController;
	@Autowired
	private CourseRepository courseRepository;
	
	private Course course = new Course();
	
	@Before
	public void setup() throws Exception {
		File file1 = new File("src/main/resources/static/images/timg.jpeg"); 
		FileInputStream input1 = new FileInputStream(file1); 
		multipartFile1 = new MockMultipartFile("file", file1.getName(), "image/jpeg", input1);
		request = new MockMultipartHttpServletRequest();
		request.addParameter("courseName", "C++");
		request.addParameter("description", "a language");
		request.addParameter("price", "5000");
		request.addParameter("faceTo", "students");
		request.addParameter("teacher", "Critty");
		request.addParameter("type", "IT");
	}
	
	@Test
	public void testAddCourseForNormal() throws Exception{
		request.setRequestURI("/addCourse");
		request.setMethod("POST");
		Result result = new Result(0,"success");
		request.addParameter("time", "Tue 09:00-Tue 10:00,Tue 13:00-Tue 14:00");
		assertEquals(result.getCode(),courseAddController.addCourse(multipartFile1,request).getCode());
//		courseRepository.delete(arg0);
		
	}
	@Test(expected = CourseException.class)
	public void testAddCourseForExceprion() throws Exception {
		request.setRequestURI("/addCourse");
		request.setMethod("POST");
		Result result = new Result(-3,"Please input correct time!");
		request.addParameter("time", "Tue 09:00-Tue 10:00,Tue 09:00-Tue 14:00");
		assertEquals(result.getCode(),courseAddController.addCourse(multipartFile1,request).getCode());
	}
	@Test(expected = CourseException.class)
	public void testAddCourseForSameNameExceprion() throws Exception {
		request.setRequestURI("/addCourse");
		request.setMethod("POST");
		Result result = new Result(100,"The name has already existed");
		request.setParameter("courseName", "C+++");
		request.addParameter("time", "Tue 09:00-Tue 10:00,Tue 13:00-Tue 14:00");
		Integer code = courseAddController.addCourse(multipartFile1,request).getCode();
		assertEquals(result.getCode(),code);
	}
	
	@Test
	public void getCourseInfoByOldNameTest() throws Exception {
		request.setRequestURI("/editCourse/oldName/{oldName}");
		Course c = new Course();
		c.setCourseName("C+++");
		assertEquals(c.getCourseName(),courseAddController.getCourseInfoByOldName("C+++").getCourseName());
	}
	@Test
	public void updateCourseInfoForNormalTest() throws Exception {
		request.setRequestURI("/editCou");
		request.setMethod("POST");
		request.setParameter("oldName", "C++");
		request.setParameter("courseName", "C--");
		Result result = new Result(0,"Update the CourseInfo successfully!");
		request.addParameter("time", "Tue 09:00-Tue 10:00,Tue 13:00-Tue 14:00");
		assertEquals(result.getCode(),courseAddController.updateCourseInfo(multipartFile1, request).getCode());;
		courseRepository.deleteByCourseName("C--");
	}
}
