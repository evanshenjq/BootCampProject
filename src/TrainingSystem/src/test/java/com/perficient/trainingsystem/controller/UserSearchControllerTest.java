package com.perficient.trainingsystem.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.perficient.trainingsystem.exception.CompanyException;
import com.perficient.trainingsystem.model.UserSearchResult;
import com.perficient.trainingsystem.repository.CompanyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSearchControllerTest {

	@Autowired
	UserSearchController userSearchController;
	private MockMultipartHttpServletRequest request;

	@Autowired
	private CompanyRepository companyRepository;

	
	private static String SORTBYPOPULARITY = "1";
	
	@Test
	public void testUserSearchController() throws CompanyException {

		request = new MockMultipartHttpServletRequest();
		request.setRequestURI("/search");
		request.addParameter("searchKey", "");
		request.addParameter("filter", " ,, ");
		request.addParameter("sort", SORTBYPOPULARITY);
		List<UserSearchResult> userSearchResults = userSearchController.UserSearchByKey(request);
//		assertEquals(companyRepository.findAll().size() - 1, userSearchResults.size());
	}

}
