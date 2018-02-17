package com.perficient.trainingsystem.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.perficient.trainingsystem.controller.CompanyListController;
import com.perficient.trainingsystem.exception.CompanyException;
import com.perficient.trainingsystem.model.Company;
import com.perficient.trainingsystem.model.CompanyListResult;
import com.perficient.trainingsystem.service.CompanyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyListControllerTest {
	@Autowired
	CompanyListController companyListController;
	@Autowired
	CompanyService companyService;
	
	private MockMultipartHttpServletRequest request=new MockMultipartHttpServletRequest();
	@Before
	public void setupContext() {
		request.addParameter("page", "1");
		request.setRequestURI("backStage/{page}");
		request.setMethod("GET");
	}
	
	@Test(expected = CompanyException.class)	
//	@Test
	public void testCompanyList() throws Exception{
		List<Company> companies=new ArrayList<Company>();
		int page = 1;
		CompanyListResult result = new CompanyListResult(100, 1, companies);
		assertEquals(result.getNowPage(), companyListController.showListCompany(1).getNowPage());
		assertEquals(result.getNowPage(), companyListController.showListCompany(100).getNowPage());
		assertEquals(result.getNowPage(), companyListController.showListCompany(-1).getNowPage());
		companyService.findCompaniesByPage(page, companies);
		
		
	}
}
