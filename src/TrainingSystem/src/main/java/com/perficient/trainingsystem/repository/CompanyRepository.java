package com.perficient.trainingsystem.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.perficient.trainingsystem.model.Company;

import java.util.List;


public interface  CompanyRepository  extends MongoRepository<Company, String> {
	Company findByName(String name);	
	void deleteByName(String name);
	public Company findByNameIgnoreCase(String name);
	public List<Company> findByNameLikeIgnoreCase(String name, Sort sort);
	public List<Company> findByTypeLikeIgnoreCase(String type, Sort sort);
	public Company findById(String id);
	public List<Company> findByAddress(String address);
}
