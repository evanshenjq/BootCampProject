package com.perficient.trainingsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.perficient.trainingsystem.model.Company;
import com.perficient.trainingsystem.model.CompanyListResult;
import com.perficient.trainingsystem.repository.CompanyRepository;
import com.perficient.trainingsystem.service.CompanyService;
import com.perficient.trainingsystem.utils.ImageUtilDateBase;

@Controller
public class CompanyListController {
	
	@Autowired
	private CompanyService companyService;
	@Autowired CompanyRepository companyRepository;
	
	
	@RequestMapping("/backStage/{page}")
	@ResponseBody
	public CompanyListResult showListCompany(@PathVariable int page) throws Exception{
		
		if(page <= 0 || page > companyService.getLastPage(companyRepository.findAll())) {
			page=1;
		}
		Sort sort = new Sort(Direction.DESC, "id");
		List<Company> companies = companyService.findCompaniesByPage(page, companyRepository.findAll(sort));
		
		//get logo
		companies = convertLogos(companies);
		
		return new CompanyListResult(companyService.getLastPage(companyRepository.findAll()), 
				page, companies );
	}
	
	@RequestMapping("/backStage/key/{page}")
	@ResponseBody
	public CompanyListResult searchCompaniesByKey(@PathVariable int page, @RequestParam("key") String key)throws Exception{
		
		List<Company> orgs = companyService.findCompaniesByKey(key);
		if(orgs == null || orgs.isEmpty())
			return new CompanyListResult(0, 1, null);
		
		if(page <= 0 || page > companyService.getLastPage(orgs) ) {
			page=1;
		}
		List<Company> organizations = companyService.findCompaniesByPage(page, orgs);
		//get logo
		organizations = convertLogos(organizations);
		return new CompanyListResult(companyService.getLastPage(orgs), page, orgs.size(), organizations);
	}
	
	public List<Company> convertLogos(List<Company> companies) throws Exception{
		for(int i=0; i<companies.size(); i++) {
			String filename = companies.get(i).getLogo();
			if(ImageUtilDateBase.getImage(filename)!=null)
				filename = ImageUtilDateBase.getImage(filename);
			companies.get(i).setLogo(filename);
		}
		return companies;
	}
}
