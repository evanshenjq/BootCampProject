package com.perficient.trainingsystem.controller;

import java.text.ParseException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.perficient.trainingsystem.model.Course;
import com.perficient.trainingsystem.model.Result;
import com.perficient.trainingsystem.model.UserCourse;
import com.perficient.trainingsystem.repository.CourseRepository;
import com.perficient.trainingsystem.repository.UserSignInCourseRepository;
import com.perficient.trainingsystem.service.UserCourseService;

@Controller
public class UserCourseController {
	@Autowired
	UserCourseService userCourseService;
	@Autowired
	UserSignInCourseRepository userSignInCourseRepository;
	@Autowired
	CourseRepository courseRepository;
	
	@RequestMapping(value = "/user/getCourse")
	@ResponseBody
	public List<Course> findCourseByUserId(@RequestParam String userId) { 
		List<Course> lc = userCourseService.findCourseByUserId(userId);
		for(int i=0;i<lc.size();i++) {
			if(lc.get(i).getDescription().length()>40) {
				lc.get(i).setDescription(lc.get(i).getDescription().substring(0,40)+"...");
			}
		}
		return lc;
	}
	
	@RequestMapping(value = "/user/reserveCourse" ,method = { RequestMethod.POST})
	@ResponseBody
	public Result reserveCourseByUserIdAndCourseId(@RequestParam String userId, @RequestParam String courseId) throws ParseException
	{		
		UserCourse uc = new UserCourse();
		uc.setUserId(userId);
		uc.setCourseId(courseId);
		return userCourseService.saveUserCourse(uc);
	}
	
	@RequestMapping(value = "/user/signedInLessons")
	@ResponseBody
	public List<Course> findUserSignedCourse(@RequestParam String userId) {
		return userCourseService.findSignedCourseBySort(userId);
	}
	
	@RequestMapping(value = "/user/course/dates" ,method = { RequestMethod.POST})
	@ResponseBody
	public List<String> findCoursesDates(@RequestParam String userId) {
		return userCourseService.allUserCourseDates(userId);
	}
}