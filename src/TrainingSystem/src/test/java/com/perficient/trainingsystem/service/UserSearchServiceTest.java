package com.perficient.trainingsystem.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.perficient.trainingsystem.exception.CompanyException;
import com.perficient.trainingsystem.model.Company;
import com.perficient.trainingsystem.model.Course;
import com.perficient.trainingsystem.repository.CompanyRepository;
import com.perficient.trainingsystem.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSearchServiceTest {
	@Autowired
	UserSearchService userSearchService;
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	CourseRepository courseRepository;

	private Map<Company, List<Course>> map;
	
	
	
	private static Integer SORTBYPOPULARITY = 1;
	
	private static Integer SORTBYSCORE = 2;
	@Test
	public void testUserFilterByKeys() throws CompanyException{
		//test blank search
		String filterK[] = {"", "", ""}, searchK="";
		Map<Company, List<Course>> map = userSearchService.userFilterByKeys(filterK, searchK);
//		assertEquals(companyRepository.findAll().size()-1, map.size());
		//test exist search
		filterK[0] = "Pre school"; filterK[1] = "one-to-one"; filterK[2] = "add1";
		map = userSearchService.userFilterByKeys(filterK, searchK);
		assertEquals(false, map.isEmpty());

		filterK[0] = "ITtttt"; filterK[1] = ""; filterK[2] = "";
		map = userSearchService.userFilterByKeys(filterK, searchK);
		assertEquals(true, map.isEmpty());
	}
	
	@Test
	public void testUserSearchInfoByKey() throws CompanyException {
		map = new HashMap<Company,List<Course>>();
		String key = "j";
		map = userSearchService.userSearchInfoByKey(key);
		assert(map!=null);
	}
	
	@Test
	public void testUserSearchResultSortByPopularity() throws CompanyException {

		List<Company> companies = getUserSearchResult(SORTBYPOPULARITY);
		for (int x = 0; x < companies.size() - 1; x++) {
			assert (Integer.valueOf(companies.get(x).getPopularity())
					- Integer.valueOf(companies.get(x + 1).getPopularity()) >= 0);
		}

	}

	@Test
	public void testUserSearchResultSortByScore() throws CompanyException {

		List<Company> companies = getUserSearchResult(SORTBYSCORE);
		for (int x = 0; x < companies.size() - 1; x++) {
			assert (Double.valueOf(companies.get(x).getScore())
					- Double.valueOf(companies.get(x + 1).getScore()) >= 0);
		}

	}

	private List<Company> getUserSearchResult(Integer sort) throws CompanyException {
		String searchKey = "";
		String filter = "a, , ";

		Map<Company, List<Course>> userSearchResults = userSearchService.userSortKey(filter.split(","), searchKey,
				sort);
		Iterator<Company> iter = userSearchResults.keySet().iterator();

		List<Company> companies = new ArrayList<Company>();
		while (iter.hasNext()) {
			companies.add(iter.next());
		}
		return companies;
	}

}
