package com.perficient.trainingsystem.controller;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import com.perficient.trainingsystem.exception.CompanyException;
import com.perficient.trainingsystem.model.Company;
import com.perficient.trainingsystem.model.Result;
import com.perficient.trainingsystem.repository.CompanyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyEditControllerTest {
	
	private MultipartFile multipartFile1;
	private MultipartFile multipartFile2;
	private MultipartFile[] picture;
	private MockMultipartHttpServletRequest request;
	
	@Autowired
	private CompanyEditController companyEditController;
	@Autowired
	private CompanyRepository companyRepository;
	
	private String[] str = new String[]{"1513826366145","1513834593469"};
	
	@Before
	public void setUp() throws Exception {
		File file1 = new File("src/main/resources/static/images/timg.jpeg"); 
		File file2 = new File("src/main/resources/static/images/timgq.jpeg"); 
		FileInputStream input1 = new FileInputStream(file1); 
		multipartFile1 = new MockMultipartFile("file", file1.getName(), "image/jpeg", input1);		
		FileInputStream input2 = new FileInputStream(file2); 
		multipartFile2 = new MockMultipartFile("file", file1.getName(), "image/jpeg", input2);				
		request = new MockMultipartHttpServletRequest();		
		picture = new  MultipartFile[] {multipartFile1,multipartFile2};
		request.addParameter("oldName", "");
		request.addParameter("name", "");
		request.addParameter("type", "IT");
		request.addParameter("introduce", "agile");
		request.addParameter("address", "HZ");
		request.addParameter("phone", "17826853395");
		//request.setRequestURI("/addcomp");
		request.setMethod("POST");
	}
	
	@Test(expected = CompanyException.class)
	public void editCompanyForException() throws Exception{
		Company company = new Company();
		company.setAddress("binjiang");
		company.setName("vetty3");
		company.setScore("0");
		company.setPopularity("0");
		companyRepository.save(company);
		request.setParameter("oldName", "vetty3");
		request.setParameter("name", "vetty4");
		Result result = new Result(-1,"The name has already exist!");
		assertEquals(result.getCode(),companyEditController.updateCompany(
																multipartFile1, picture,str,request).getCode());
		companyRepository.deleteByName("vetty4");	
		
	}
	@Test
	public void editCompanyForNormal() throws Exception{
		Company company = new Company();
		company.setName("vetty1234");
		company.setScore("0");
		company.setPopularity("0");
		companyRepository.save(company);
		request.setParameter("oldName", "vetty1234");
		request.setParameter("name", "vetty4321");
		Result result = new Result(0,"Update the orginization successfully!");
		assertEquals(result.getCode(),companyEditController.updateCompany(
																multipartFile1, picture,str,request).getCode());
		companyRepository.deleteByName("vetty4321");				
	}
	@Test
	public void editCompanyForNullLogo() throws Exception{
		Result result = new Result(0,"Update the orginization successfully!");
//		assertEquals(result.getCode(),companyEditController.updateCompany(
//																multipartFile1, picture, request).getCode());
		
	}
	@Test
	public void getByOldNameTest() throws Exception{
		Company company = new Company();
		company.setName("hzp");
		assertEquals(company.getName(),companyEditController.getByOldName("hzp").getName());	
	}


}
