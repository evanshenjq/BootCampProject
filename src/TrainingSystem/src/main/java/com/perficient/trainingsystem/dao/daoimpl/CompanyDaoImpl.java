package com.perficient.trainingsystem.dao.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.perficient.trainingsystem.dao.CompanyDao;
import com.perficient.trainingsystem.repository.CompanyRepository;

@Component
public class CompanyDaoImpl implements CompanyDao {
	
	@Autowired
	private CompanyRepository companyRepository;	
}
