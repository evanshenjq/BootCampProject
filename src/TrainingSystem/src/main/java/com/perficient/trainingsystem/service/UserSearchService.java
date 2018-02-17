package com.perficient.trainingsystem.service;

import java.util.List;
import java.util.Map;

import com.perficient.trainingsystem.exception.CompanyException;
import com.perficient.trainingsystem.model.Company;
import com.perficient.trainingsystem.model.Course;

public interface UserSearchService {
	public Map<Company,List<Course>> userSortKey(String[] filterK,String searchK,Integer sort) throws CompanyException;
	public Map<Company,List<Course>> userFilterByKeys(String[] filterK, String searchK) throws CompanyException;
	public Map<Company,List<Course>> userSearchInfoByKey(String key) throws CompanyException;
}
