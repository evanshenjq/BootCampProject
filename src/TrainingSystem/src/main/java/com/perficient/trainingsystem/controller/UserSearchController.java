package com.perficient.trainingsystem.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.perficient.trainingsystem.exception.CompanyException;
import com.perficient.trainingsystem.model.Company;
import com.perficient.trainingsystem.model.Course;
import com.perficient.trainingsystem.model.UserSearchResult;
import com.perficient.trainingsystem.repository.CourseRepository;
import com.perficient.trainingsystem.service.UserSearchService;

@Controller
public class UserSearchController {
	@Autowired
	private UserSearchService userSearchService;
	@Autowired
	private CourseRepository courseRepository;
	private Map<Company, List<Course>> map;


	@RequestMapping(value = "/search")
	@ResponseBody
	public List<UserSearchResult> UserSearchByKey(HttpServletRequest request) throws CompanyException {

		String searchKey = request.getParameter("searchKey");

		String[] filter = request.getParameter("filter").split(",");
		for(int i=0; i<filter.length; i++) {
			filter[i] = filter[i].trim();
		}
		Integer sort = Integer.valueOf(request.getParameter("sort"));

		map = userSearchService.userSortKey(filter, searchKey, sort);

		// make the map into the Model
		List<UserSearchResult> userSearchResults = new ArrayList<UserSearchResult>();
		Set<Entry<Company, List<Course>>> entry = map.entrySet();
		Iterator<Entry<Company, List<Course>>> iter = entry.iterator();
		while (iter.hasNext()) {
			Entry<Company, List<Course>> entry2 = iter.next();
			UserSearchResult userSearchResult = new UserSearchResult();

			userSearchResult.setCompany(entry2.getKey());
			userSearchResult.setCourses(entry2.getValue());

			userSearchResults.add(userSearchResult);
		}		
		System.out.println(userSearchResults.size());
		return userSearchResults;
	}
	
	@RequestMapping(value = "/company/courses",  method = { RequestMethod.POST})
	@ResponseBody
	public List<Course> findCourseByCompId(@RequestParam String companyId){
		return courseRepository.findByCompanyId(companyId);
	}

}