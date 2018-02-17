package com.perficient.trainingsystem.model;

import java.util.List;

public class UserSearchResult {
	private Company company;
	
	private List<Course> courses;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "UserSearchResult [company=" + company + ", courses=" + courses + "]";
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
}
