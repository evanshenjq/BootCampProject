package com.perficient.trainingsystem.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.perficient.trainingsystem.model.Course;

public interface CourseRepository extends MongoRepository<Course, String>{
	public List<Course> findBycourseNameLikeIgnoreCase(String courseName, Sort sort);
	
	public List<Course> findBycompanyId(String courseId,Sort sort);
	
	public void deleteByCourseName(String courseName);
	
	public Course findByCourseNameIgnoreCase(String courseName);
	
	public List<Course> findByCompanyId(String companyId);
	
	public List<Course> findById(String courseId);
}