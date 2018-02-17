package com.perficient.trainingsystem.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UserSearchResultTest {

	@Test
	public void test() {
		Company company = new Company();
		company.setName("ZJGSU");
		Course c1 = new Course();
		c1.setCourseName("English");
		Course c2 = new Course();
		c1.setCourseName("Chinese");
		List<Course> cs = new ArrayList<Course>();
		UserSearchResult usr = new UserSearchResult();
		usr.setCompany(company);
		usr.setCourses(cs);
		usr.getCompany();
		usr.getCourses();
		usr.toString();
		usr.equals(usr);
	}

}
