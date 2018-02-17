package com.perficient.trainingsystem.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.perficient.trainingsystem.model.UserCourse;

public interface UserCourseRepository extends MongoRepository<UserCourse, String>{
	public List<UserCourse> findByUserId(String userId);
	public UserCourse findByUserIdAndCourseId(String userId, String courseId);
}
