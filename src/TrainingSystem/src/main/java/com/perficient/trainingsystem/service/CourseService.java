package com.perficient.trainingsystem.service;

import java.util.List;

import com.perficient.trainingsystem.exception.CourseException;
import com.perficient.trainingsystem.model.Course;

public interface CourseService {
	public int getLastPage(List<Course> courses);
	public List<Course> findCoursesByPage(int page,List<Course> courses) throws CourseException;
	public List<Course> findCourseByKeyWord(String key) throws CourseException;
	public void delCourse(String [] ns) throws Exception;
	public void addCourse(Course course) throws CourseException;
}
