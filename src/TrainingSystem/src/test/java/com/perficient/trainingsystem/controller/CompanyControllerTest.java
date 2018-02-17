package com.perficient.trainingsystem.controller;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import com.perficient.trainingsystem.exception.CompanyException;
import com.perficient.trainingsystem.model.Result;
import com.perficient.trainingsystem.repository.CompanyRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
/*@AutoConfigureMockMvc*/
public class CompanyControllerTest {
	
	/*@Autowired
    private MockMvc mvc;*/
	
	private MultipartFile multipartFile1;
	private MultipartFile multipartFile2;
	private MockMultipartHttpServletRequest request;
	
	@Autowired
	private CompanyController companyController;
	@Autowired
	private CompanyRepository companyRepository;
	private MultipartFile[] picture;

	@Before
	public void setup() throws Exception{
		File file1 = new File("src/main/resources/static/images/timg.jpeg"); 
		File file2 = new File("src/main/resources/static/images/timgq.jpeg"); 
		FileInputStream input1 = new FileInputStream(file1); 
		multipartFile1 = new MockMultipartFile("file", file1.getName(), "image/jpeg", input1);		
		FileInputStream input2 = new FileInputStream(file2); 
		multipartFile2 = new MockMultipartFile("file", file1.getName(), "image/jpeg", input2);				
		request = new MockMultipartHttpServletRequest();		
		request = new MockMultipartHttpServletRequest();
		picture = new  MultipartFile[] {multipartFile1,multipartFile2};
//		request.addFile(multipartFile1);
//		request.addFile(multipartFile2);		
		request.addParameter("type", "IT");
		request.addParameter("introduce", "agile");
		request.addParameter("address", "HZ");
		request.addParameter("phone", "17826853395");
		request.setRequestURI("/addcomp");
		request.setMethod("POST");
	}
	
	/*@Test
	public void testShowListCompany() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/backStage/10"))
        .andExpect(MockMvcResultMatchers.status().isOk());
	}	*/

	@Test
	public void testAddCompanyForNormal() throws Exception{
		Result result = new Result(0,"success");
		request.addParameter("name","vetty1234");						
		assertEquals(result.getCode(),companyController.addCompany(multipartFile1, picture, request).getCode());
		//to make sure no user called "gfgjj" in DB
		//companyRepository.deleteByName("vetty1234");		
	}
	
	@Test(expected = CompanyException.class)
	public void testAddCompanyForExceptional() throws Exception{
		Result result = new Result(-1,"unknow err");
		request.addParameter("name", "hzp");
		assertEquals(result.getCode(),companyController.addCompany(multipartFile1, picture, request).getCode());		
	}
	
//	volume production
//	@Test
//	public void add() throws Exception
//	{
//		
//		Result result = new Result(0,"success");
//		request.addParameter("name","mia");	
//		for(int i=1;i<60;i++)
//		{			
//			Integer num = Integer.valueOf(i);						
//			request.setParameter("name", "vetty"+num);
//			assertEquals(result.getCode(),companyController.addCompany(multipartFile1, picture, request).getCode());
//		}
//	}
	
	 @Test
	 public void testDelCompany() {
		 String names = "vetty1234";
		 companyController.delCompany(names);
	 }
	 
	 @Test
	 public void testFindCompanyById() {
		 companyController.findCompanyById(companyRepository.findAll().get(0).getId());
	 }
	 
	 
}
	
