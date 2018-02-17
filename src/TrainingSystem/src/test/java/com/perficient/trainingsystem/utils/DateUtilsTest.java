package com.perficient.trainingsystem.utils;

import java.util.Date;

import org.junit.Test;

public class DateUtilsTest {

	@Test
	public void test() {
		String day = "2018-01-23";
		Date date = new Date();
		DateUtils.formateDate(date);
		DateUtils.getWeekOfDate(date);
		String patternA = "yyyy-MM-dd";  
		DateUtils.dateToString(date,patternA);
		DateUtils.stringToDate(day,patternA);
		DateUtils.getDate();
	}

}
