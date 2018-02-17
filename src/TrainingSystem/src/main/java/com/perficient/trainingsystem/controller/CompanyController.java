package com.perficient.trainingsystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.perficient.trainingsystem.exception.CompanyException;
import com.perficient.trainingsystem.model.Company;
import com.perficient.trainingsystem.model.Result;
import com.perficient.trainingsystem.service.CompanyService;
import com.perficient.trainingsystem.utils.ImageUtilDateBase;

@Controller
public class CompanyController {
	
	@Autowired  
    public CompanyService companyService;  
	    
    //Add company
	@RequestMapping(value = "/addComp" ,method = { RequestMethod.POST})
	@ResponseBody
	public Result addCompany(@RequestParam("logo") MultipartFile logo,@RequestParam("introphoto") MultipartFile[] picture,HttpServletRequest request) throws Exception  {
			Company company = new Company();
			company.setAddress(request.getParameter("address"));
			company.setIntroduce(request.getParameter("introduce"));
			company.setName(request.getParameter("name").trim());
			company.setPhone(request.getParameter("phone"));
			company.setType(request.getParameter("type"));
			company.setPopularity("0");
			company.setScore("0");
			company.setLogo(ImageUtilDateBase.saveImage(logo, request));
			company.setIntroPhoto(ImageUtilDateBase.saveImages(picture, request));		
			companyService.addCompany(company);
		return new Result(0,"Create the orginization successfully!",company);
    }  
	
	//delete Company
	@RequestMapping(value = "/delComp")
	@ResponseBody
	public Result delCompany(@RequestParam("names") String names) {
		String[] ns = names.split(",");
		companyService.delComp(ns);
		return new Result(0,"Delete the orginization successfully!");
	}
	
	//findCompanyById
	@RequestMapping(value = "/findComp/{id}",method ={ RequestMethod.GET })
	@ResponseBody
	public Result findCompanyById(@PathVariable String id) {
		Company company=companyService.findCompanyById(id);
		return new Result(0,"find Company By ID successfully!",company);
	}
    
}