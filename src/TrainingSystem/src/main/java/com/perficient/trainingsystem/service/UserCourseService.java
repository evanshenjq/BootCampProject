package com.perficient.trainingsystem.service;

import java.text.ParseException;
import java.util.List;

import com.perficient.trainingsystem.model.Course;
import com.perficient.trainingsystem.model.Result;
import com.perficient.trainingsystem.model.UserCourse;
import com.perficient.trainingsystem.model.UserSignInCourse;

public interface UserCourseService {
	public List<Course> findSignedCourseBySort(String userId);
	public List<String> allUserCourseDates(String userId);
	public List<UserCourse> findByUserId(String userId);
	public Integer getClassNo(UserSignInCourse usi);
	public List<Course> findCourseByUserId(String userId);
	public Result saveUserCourse(UserCourse uc)throws ParseException;
}