package com.perficient.trainingsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.perficient.trainingsystem.model.User;

@Repository("user")
public interface UserRepository extends MongoRepository<User, String>{
	
	@Query(value="{'username':?0, 'password':?1}")
	User findUserByNameAndPwd(String username,String password);
	

}
