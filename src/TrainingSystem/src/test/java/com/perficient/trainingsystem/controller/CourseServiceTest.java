package com.perficient.trainingsystem.controller;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.perficient.trainingsystem.exception.CourseException;
import com.perficient.trainingsystem.model.Course;
import com.perficient.trainingsystem.repository.CourseRepository;
import com.perficient.trainingsystem.service.CourseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {
	@Autowired
	CourseService courseService;
	
	@Autowired
	private CourseRepository courseRepository;
	@Test(expected = CourseException.class)
	public void findCourseAsInputEmptyListThrowsException() throws Exception{
//		try{
//	       
//	        fail("No exception thrown.");
//	    }catch(Exception ex){
//	        assertTrue(ex instanceof CourseException);
//	        assertTrue(ex.getMessage().contains("No item"));
//	    }
		 courseService.findCoursesByPage(1, new ArrayList<Course>());
	}
	
}
