package com.perficient.trainingsystem.service;

import java.util.List;

import com.perficient.trainingsystem.exception.CompanyException;
import com.perficient.trainingsystem.model.Company;

public interface CompanyService {
	
	public List<Company> findCompaniesByPage(int page, List<Company> companies)throws CompanyException;
	public List<Company> findCompaniesByKey(String key)throws CompanyException;
	public void addCompany(Company company) throws CompanyException ;
	public int getLastPage(List<Company> companies);
	public void delComp(String[] names);
	public void delACompany(String oldName);
	public Company findCompanyById(String id);
	public void delPictures(String[] delPics,Company oldcompany);
}
