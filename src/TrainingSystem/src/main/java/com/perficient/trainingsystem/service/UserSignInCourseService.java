package com.perficient.trainingsystem.service;


import java.util.List;

import com.perficient.trainingsystem.model.Course;
import com.perficient.trainingsystem.model.UserCourse;
import com.perficient.trainingsystem.model.UserSignInCourse;


public interface UserSignInCourseService {
	 public UserCourse reservedOrNot(String userId, String courseId);
	 public UserSignInCourse checkedInOrNot(UserSignInCourse userSignInCourse);
     public void signSusseed(UserSignInCourse userSignInCourse);
	 
}
