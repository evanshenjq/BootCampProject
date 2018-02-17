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

import com.perficient.trainingsystem.model.Company;
import com.perficient.trainingsystem.model.Result;
import com.perficient.trainingsystem.repository.CompanyRepository;
import com.perficient.trainingsystem.service.CompanyService;
import com.perficient.trainingsystem.utils.ImageUtilDateBase;

@Controller
public class CompanyEditController {
	
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CompanyRepository companyRepository; 
	
	@RequestMapping("/editCompany/oldName/{oldName}")
	@ResponseBody
	public Company getByOldName(@PathVariable String oldName) throws Exception 
	{	
		Company company = companyRepository.findByName(oldName);
		company.setLogo(ImageUtilDateBase.getImage(company.getLogo()));
		company.setIntroPhoto(ImageUtilDateBase.getImages(company.getIntroPhoto()));
		return company;
	}
	
	@RequestMapping(value = "/editComp" ,method = { RequestMethod.POST})
	@ResponseBody
	public Result updateCompany(@RequestParam("logo") MultipartFile logo,
								@RequestParam("introphoto") MultipartFile[] picture,
								@RequestParam("delPic") String[] delPics,
								HttpServletRequest request) throws Exception
	{
		Company oldcompany = companyRepository.findByName(request.getParameter("oldName").trim());
		oldcompany.setAddress(request.getParameter("address"));
		oldcompany.setIntroduce(request.getParameter("introduce"));
		oldcompany.setName(request.getParameter("name").trim());
		oldcompany.setPhone(request.getParameter("phone"));
		oldcompany.setType(request.getParameter("type"));
		if(logo.getBytes().length != 0) {
			oldcompany.setLogo(ImageUtilDateBase.saveImage(logo, request));
		}
		if(picture[0].getBytes().length != 0) {
			oldcompany.setIntroPhoto(ImageUtilDateBase.saveImages(picture, request));	
		}
		companyService.delPictures(delPics,oldcompany);
		companyService.addCompany(oldcompany);
		return new Result(0,"Update the orginization successfully!",oldcompany);		
	}
}
