package com.perficient.trainingsystem.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.perficient.trainingsystem.model.UserSignInCourse;

public interface UserSignInCourseRepository extends MongoRepository<UserSignInCourse, String>{
	public List<UserSignInCourse> findByUserId(String userId);
	public UserSignInCourse findByUserIdAndCourseIdAndCourseTime(String userId, String courseId, String courseTime);
}
