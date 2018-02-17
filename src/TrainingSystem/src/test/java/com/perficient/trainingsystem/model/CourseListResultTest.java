package com.perficient.trainingsystem.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CourseListResultTest {

	@Test
	public void test() {
		Course c1 = new Course();
		c1.setCourseName("English");
		Course c2 = new Course();
		c1.setCourseName("Chinese");
		List<Course> cs = new ArrayList<Course>();
		CourseListResult clr = new CourseListResult(4,3,5,cs);
		clr.setData(null);;
		clr.setItems(2);
		clr.setNowPage(1);
		clr.setTotalPage(3);
		clr.getData();
		clr.getNowPage();
		clr.getTotalPage();
		clr.getItems();
	}

}
