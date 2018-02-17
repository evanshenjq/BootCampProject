package com.perficient.trainingsystem.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.perficient.trainingsystem.controller.CompanyListController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchCompaniesByKeyTest {
	@Autowired
	CompanyListController companyListController;
	
	private MockMultipartHttpServletRequest request=new MockMultipartHttpServletRequest();
	@Before
	public void SetupContext() {
		request.setMethod("GET");
	}
	
	@Test
	public void testSearchCompaniesByKey() throws Exception{
		request.setRequestURI("backStage/key/{page}");
		//1

		int page=1;
		assertEquals((Integer)1, companyListController.searchCompaniesByKey(page, "").getNowPage());
		assertEquals((Integer)1, companyListController.searchCompaniesByKey(page, "com").getNowPage());
		assertEquals((Integer)1, companyListController.searchCompaniesByKey(page, "233333").getNowPage());
		page = -1;
		assertEquals((Integer)(1), companyListController.searchCompaniesByKey(page, "2").getNowPage());
		page = 10;
		assertEquals((Integer)(1), companyListController.searchCompaniesByKey(page, "2").getNowPage());
	}
}
