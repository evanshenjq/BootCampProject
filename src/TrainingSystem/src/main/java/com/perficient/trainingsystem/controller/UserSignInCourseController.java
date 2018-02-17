package com.perficient.trainingsystem.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.perficient.trainingsystem.model.Course;
import com.perficient.trainingsystem.model.Result;
import com.perficient.trainingsystem.model.UserSignInCourse;
import com.perficient.trainingsystem.service.UserSignInCourseService;
@Controller
public class UserSignInCourseController {

	@Autowired
	private UserSignInCourseService userSignInCourseService;
	
	

	@RequestMapping(value = "/signInCourse")
	@ResponseBody
	public Result saveSignInCourse(HttpServletRequest request) {
		
		UserSignInCourse userSignInCourse = new UserSignInCourse();
		String userId = request.getParameter("userId");
		String courseId = request.getParameter("courseId");
		String courseTime = request.getParameter("courseTime");
	
		userSignInCourse.setUserId(userId);
		userSignInCourse.setCourseId(courseId);
		userSignInCourse.setCourseTime(courseTime);
		
		if(userSignInCourseService.reservedOrNot(userId,courseId)==null) {
			return new Result(410,"You have not reserved the course yet!");
		}else{
			if(userSignInCourseService.checkedInOrNot(userSignInCourse)!=null) {
				return new Result(409,"You have signed in before!");				
			}else {
				userSignInCourseService.signSusseed(userSignInCourse);
			    return new Result(200,"Sign in successfully!",userSignInCourse);
			}
			
		}	
	}
}
