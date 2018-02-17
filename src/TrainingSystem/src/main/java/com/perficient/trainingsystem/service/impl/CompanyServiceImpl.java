package com.perficient.trainingsystem.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.perficient.trainingsystem.enums.ResultEnum;
import com.perficient.trainingsystem.exception.CompanyException;
import com.perficient.trainingsystem.model.Company;
import com.perficient.trainingsystem.repository.CompanyRepository;
import com.perficient.trainingsystem.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	private static final int PAGE_SIZE = 12;
	
	@Autowired CompanyRepository companyRepository;
	
	public List<Company> findCompaniesByPage(int page, List<Company> companies)throws CompanyException{	

		if(companies.isEmpty())
			throw new CompanyException(ResultEnum.ITEM_NULL);
		int start = (page - 1) * PAGE_SIZE;
		int end=start + PAGE_SIZE;
		if(end > companies.size())
			end = companies.size();
		return companies.subList(start, end);
	}
	
	public int getLastPage(List<Company> companies) {
		return (int)Math.ceil(1.0 * companies.size() / PAGE_SIZE);
	}
	
	public List<Company> mergeCompanies(List<Company> a, List<Company> b) {
		int i, j;
		int blen=b.size();
		for(i=0; i<a.size(); i++) {
			for(j=0; j<blen; j++) {
				if(a.get(i).getName().equals(b.get(j).getName())) {
					break;
				}
			}
			if( j== blen)
				b.add(a.get(i));
		}
		System.out.println(b.size());
		return b;
	}
	
	public List<Company> findCompaniesByKey(String key)throws CompanyException{
		Sort sort = new Sort(Direction.DESC, "id");
		List<Company> companies = companyRepository.findByNameLikeIgnoreCase(key, sort);
		List<Company> cp = companyRepository.findByTypeLikeIgnoreCase(key, sort);
		mergeCompanies( cp, companies );
		return companies;
	}
	
	
	public void addCompany(Company company) throws CompanyException{
		Company cp = companyRepository.findByNameIgnoreCase(company.getName());
		if(cp!=null&&!(cp.getId().equals(company.getId()))) {			
			throw new CompanyException(ResultEnum.SAME_COMPANYNAME);
		}else {
			companyRepository.save(company);
		}
	}
	public void delComp(String[] names) {
		for(String name:names) {
			companyRepository.deleteByName(name);
		}
	}
	
	public void delACompany(String oldName)
	{
		companyRepository.deleteByName(oldName);
	}
	
	public void delPictures(String[] delPics,Company oldcompany) {
		String[] pics = oldcompany.getIntroPhoto();
		for(int i=0;i<delPics.length;i++) {
			if(oldcompany.getLogo().equals(delPics[i])) {
				oldcompany.setLogo("");
			}
			for(int j=0;j<pics.length;j++) {
				if(pics[j].equals(delPics[i])) {
					pics[j]="";
				}
			}
			oldcompany.setIntroPhoto(pics);
		}
	}
	
	
	public Company findCompanyById(String id){
		return companyRepository.findById(id);
	}
	
}