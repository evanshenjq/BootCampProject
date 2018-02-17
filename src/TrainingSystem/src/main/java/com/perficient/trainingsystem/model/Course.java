package com.perficient.trainingsystem.model;

import org.springframework.data.annotation.Id;

public class Course {
	@Id
	private String id;
	private String logo;
	private String companyId;
	private String courseName;
	private String suitableCrowd;
	private String type;
	private String time;
	private String price;
	private String description;
	private String teacher;
	private String classHouers;
	private String courseStartTime;
	
	
	public String getCourseStartTime() {
		return courseStartTime;
	}
	public void setCourseStartTime(String courseStartTime) {
		this.courseStartTime = courseStartTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getSuitableCrowd() {
		return suitableCrowd;
	}
	public void setSuitableCrowd(String suitableCrowd) {
		this.suitableCrowd = suitableCrowd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getClassHouers() {
		return classHouers;
	}
	public void setClassHouers(String classHouers) {
		this.classHouers = classHouers;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", logo=" + logo + ", companyId=" + companyId + ", courseName=" + courseName
				+ ", suitableCrowd=" + suitableCrowd + ", type=" + type + ", time=" + time + ", price=" + price
				+ ", description=" + description + ", teacher=" + teacher + ", classHouers=" + classHouers
				+ ", courseStartTime=" + courseStartTime + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
