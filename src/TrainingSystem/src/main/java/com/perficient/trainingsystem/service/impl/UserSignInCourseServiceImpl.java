package com.perficient.trainingsystem.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perficient.trainingsystem.model.Course;
import com.perficient.trainingsystem.model.UserCourse;
import com.perficient.trainingsystem.model.UserSignInCourse;
import com.perficient.trainingsystem.repository.CourseRepository;
import com.perficient.trainingsystem.repository.UserCourseRepository;
import com.perficient.trainingsystem.repository.UserSignInCourseRepository;
import com.perficient.trainingsystem.service.UserSignInCourseService;
@Service
public class UserSignInCourseServiceImpl implements UserSignInCourseService{
	
	@Autowired
	UserCourseRepository userCourseRepository;
	@Autowired
    CourseRepository courseRepository;
	@Autowired
    UserSignInCourseRepository userSignInCourseRepository;
    
	
	public void signSusseed(UserSignInCourse u) {
		//save the course user have signed in
		userSignInCourseRepository.save(u);
		
	}

	public UserSignInCourse checkedInOrNot(UserSignInCourse u) {
		return userSignInCourseRepository.findByUserIdAndCourseIdAndCourseTime(
				u.getUserId(),u.getCourseId(),u.getCourseTime());
		
	}


	public UserCourse reservedOrNot(String userId, String courseId) {
		
		return userCourseRepository.findByUserIdAndCourseId(userId,courseId);    		
		 
	}

}
