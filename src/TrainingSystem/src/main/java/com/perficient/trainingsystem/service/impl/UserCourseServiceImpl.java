package com.perficient.trainingsystem.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perficient.trainingsystem.model.Course;
import com.perficient.trainingsystem.model.Result;
import com.perficient.trainingsystem.model.UserCourse;
import com.perficient.trainingsystem.model.UserSignInCourse;
import com.perficient.trainingsystem.repository.CourseRepository;
import com.perficient.trainingsystem.repository.UserCourseRepository;
import com.perficient.trainingsystem.repository.UserSignInCourseRepository;
import com.perficient.trainingsystem.service.UserCourseService;
import com.perficient.trainingsystem.utils.DateUtils;

@Service
public class UserCourseServiceImpl implements UserCourseService{
	
	@Autowired
	UserSignInCourseRepository userSignInCourseRepository;
	@Autowired
	private UserCourseRepository userCourseRepository;
	@Autowired
	private CourseRepository courseRepository;
	
	private static final String SUCCESS_MSG="Reserve the course successfully!";
	private static final String WARN_MSG="Warning!Time conflict exists.";
	private static final String SAME_MSG="Warning!You've reserved the course already.";
	
	public List<Course> findCourseByUserId(String userId) {
		List<UserCourse> userCourse = userCourseRepository.findByUserId(userId);
		 List<Course> courseToUser = new ArrayList();
		 for(int i=0;i<userCourse.size();i++) {
			 courseToUser.add(courseRepository.findById(userCourse.get(i).getCourseId()).get(0));
		 }
		 return courseToUser;
	}
	
	public Result saveUserCourse(UserCourse uc) throws ParseException {
		Course reservedCourse = courseRepository.findById(uc.getCourseId()).get(0);
	    String[] reservedDays = reservedCourse.getTime().split(",");	   
	    String resStartTimeString = reservedCourse.getCourseStartTime();	    	   
	    String[] days;
	    List<Course> courseToUser = findCourseByUserId(uc.getUserId());
	    String existedStartTimeString = "";
	    Date existedStartTime;
	    Date existedEndTime;
	    Date resStartTime = DateUtils.CalStartAndEndTime(resStartTimeString,reservedCourse.getClassHouers(),reservedDays).get(0);
	    Date resEndTime = DateUtils.CalStartAndEndTime(resStartTimeString,reservedCourse.getClassHouers(),reservedDays).get(1);
	    System.out.println(reservedCourse.getId());
	    System.out.println(courseToUser.size());
	    for(Course ctu: courseToUser){
	    	days = ctu.getTime().split(",");
	    	existedStartTimeString = ctu.getCourseStartTime();
	    	existedStartTime = DateUtils.CalStartAndEndTime(existedStartTimeString,ctu.getClassHouers(),days).get(0);
	    	existedEndTime = DateUtils.CalStartAndEndTime(existedStartTimeString,ctu.getClassHouers(),days).get(1);
	    	System.out.println(ctu.getId());
	    	if(reservedCourse.getId().equals(ctu.getId())) {
	    		System.out.println(ctu.getId());
	    		return new Result(1,SAME_MSG,reservedCourse);
	    	}
	    	System.out.println(existedStartTime+","+existedEndTime);
	    	   for(int i=0;i<reservedDays.length;i++){
	   	    	for(int j=0;j<days.length;j++) {
	   	    		if(reservedDays[i].substring(0, 3).equals(days[j].substring(0, 3))) {
	   	    			String d1=reservedDays[i].substring(4, 9)+"-"+reservedDays[i].substring(14);
	   	    			String d2=days[i].substring(4, 9)+"-"+days[i].substring(14);
	   	    			List<String> date = new ArrayList();
	   	    			date.add(d1);
	   	    			date.add(d2);
	   	    			if(DateUtils.checkOverlap(date)) {
	   	    				if(DateUtils.judgeDateOverlapped(existedStartTime,existedEndTime,resStartTime,resEndTime))
	   	    				{
//	   	    					System.out.println("false");
	   	    					return new Result(-1,WARN_MSG,reservedCourse);
	   	    				}
	   	    				else {
	   	    					continue;
	   	    				}
	   	    					
	   	    			}
	   	    			else{
//	   	    				userCourseRepository.save(uc);
//   	    					return new Result(0,SUCCESS_MSG,reservedCourse);
	   	    				continue;
   	    				}
	   	    		}
	   	    		else
	   	    			continue;
	   	    	}	    	
	   	    }	
	    }
	    userCourseRepository.save(uc);
		return new Result(0,SUCCESS_MSG,reservedCourse);
	}
	public List<UserCourse> findByUserId(String userId) {
		return userCourseRepository.findByUserId(userId);
	}
	

	public List<Course> findSignedCourseBySort(String userId){
		List<Course> cs = new ArrayList();
		List<UserSignInCourse> usics = userSignInCourseRepository.findByUserId(userId);
		if(usics.isEmpty()) return null;
		Collections.sort(usics, new Comparator<UserSignInCourse>() {
			public int compare(UserSignInCourse u1, UserSignInCourse u2) {
				//try {
				String uscTime = u1.getCourseTime().substring(0, 10) + u1.getCourseTime().substring(14);
				Date d1 = DateUtils.stringToDate(uscTime, DateUtils.patternB);
				uscTime = u2.getCourseTime().substring(0, 10) + u2.getCourseTime().substring(14);
				Date d2 = DateUtils.stringToDate(uscTime, DateUtils.patternB);
				if(d1.getTime() > d2.getTime()) return -1;
				else return 1;
				/*} catch (Exception e) {
					e.printStackTrace();
				}
				return 0;*/
			}
		});
		Iterator<UserSignInCourse> it = usics.iterator();
		while(it.hasNext()) {
			UserSignInCourse usic = it.next();
			Course c = courseRepository.findById(usic.getCourseId()).get(0);
			if(getClassNo(usic)!=-1) {
				c.setClassHouers(getClassNo(usic).toString());
				c.setCourseStartTime(usic.getCourseTime());
				cs.add(c);
			}
		}
		return cs;
	}
	
	public Integer getClassNo(UserSignInCourse usi) {
		Course course = courseRepository.findById(usi.getCourseId()).get(0);
		List<String> days = getOneCourseDates(course);
		Iterator<String> it = days.iterator();
		int i = 0;
		while(it.hasNext()) { i++;
			if(usi.getCourseTime().equals(it.next()))	return i;
		}
		return -1;
	}
	
	public List<String> getOneCourseDates(Course c){
		List<String> ls = new ArrayList();
		if(!c.getCourseStartTime().equals("") && !c.getTime().equals("")) {
			String[] ts = c.getTime().split(",");
			if(ts.length < 1) return null;
			for(String s : ts) {
				String et = s.split("-")[0];
				String date = DateUtils.getWeekByDate(c.getCourseStartTime(), (int)DateUtils.dayToInteger(et.split(" ")[0]), DateUtils.patternA, 0);
				date = date.concat(" " + et);
				ls.add(date);
			}
		}	
		Collections.sort(ls, new Comparator<String>() {
			public int compare(String s1, String s2) {
				s1 = s1.split(" ")[0] + " " + s1.split(" ")[2];
				s2 = s2.split(" ")[0] + " " + s2.split(" ")[2];
				Date d1 = DateUtils.stringToDate(s1, DateUtils.patternB);
				Date d2 = DateUtils.stringToDate(s2, DateUtils.patternB);
				if(d1.getTime() < d2.getTime()) return -1;
				else return 1;
			}
		});
		List<Integer> ds = new ArrayList<Integer>();
		for(int i=0; i<ls.size(); i++) {
			ds.add(DateUtils.dayToInteger(ls.get(i).substring(11, 14)));	
		}
		int size = ls.size();
		int count = Integer.valueOf(c.getClassHouers()) - size;
		String nextDay = ls.get(ls.size()-1);
		nextDay = nextDay.substring(0, 10);
		for(int i = 0; i < count; i++) {
			nextDay = DateUtils.getWeekByDate(nextDay, ds.get(i % size), DateUtils.patternA, 1);
			ls.add(nextDay.concat(ls.get(i % size).substring(10)));
		}
		return ls;
	}
	
	public List<String> changeStrings(List<String> ls, String s){
		List<String> lss = new ArrayList();
		for(int i=0; !ls.isEmpty() && i < ls.size(); i++) {
			lss.add(ls.get(i)+" "+s);
		}
		return lss;
	}
	
	public List<String> allUserCourseDates(String userId) {
		List<UserCourse> lu = userCourseRepository.findByUserId(userId);
		List<Course> lc = courseRepository.findById(lu.get(0).getCourseId());
		for(int i = 1; i < lu.size(); i++) {
			lc.add(courseRepository.findById(lu.get(i).getCourseId()).get(0));
		}
		
		List<String> ls2 = new ArrayList();
		Iterator<Course> cs = lc.iterator();

		int i=0;
		while (cs.hasNext()) {
			Course c = cs.next();			
			if(!getOneCourseDates(c).isEmpty()) {
				List<String> ls = new ArrayList();
				ls.addAll(getOneCourseDates(c));
				ls2.addAll(changeStrings(ls, c.getCourseName()));
			}
		}

		Collections.sort(ls2, new Comparator<String>() {
			public int compare(String s1, String s2) {
				s1 = s1.split(" ")[0] + " " + s1.split(" ")[2];
				s2 = s2.split(" ")[0] + " " + s2.split(" ")[2];
				Date d1 = DateUtils.stringToDate(s1, DateUtils.patternB);
				Date d2 = DateUtils.stringToDate(s2, DateUtils.patternB);
				if(d1.getTime() < d2.getTime()) return -1;
				else return 1;
			}
		});
		return ls2;
	}
}