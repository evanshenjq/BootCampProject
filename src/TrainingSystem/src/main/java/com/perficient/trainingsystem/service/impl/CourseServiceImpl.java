package com.perficient.trainingsystem.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perficient.trainingsystem.enums.ResultEnum;
import com.perficient.trainingsystem.exception.CourseException;
import com.perficient.trainingsystem.model.Course;
import com.perficient.trainingsystem.repository.CourseRepository;
import com.perficient.trainingsystem.service.CourseService;
import com.perficient.trainingsystem.utils.ImageUtilDateBase;

@Service
public class CourseServiceImpl implements CourseService {
	private static final Logger logger = LoggerFactory.getLogger(CourseService.class);
	private static final int PAGE_SIZE = 8;
	@Autowired
	private CourseRepository courseRepository;
	public void addCourse(Course course) throws CourseException {
		Course c = courseRepository.findByCourseNameIgnoreCase(course.getCourseName());
		if(c==null||c.getId().equals(course.getId())){
			String[] str1 = course.getTime().split(",");
			SimpleDateFormat format = new SimpleDateFormat("EE HH:mm");
			try {
				for(int i=0;i<str1.length;i++) {
					String[] str2 = str1[i].split("-");
					Date s1 = format.parse(str2[0]);
					Date e1 = format.parse(str2[1]);
					for(int j=i+1;j<str1.length;j++) {
						String[] str3 = str1[j].split("-");
						Date s2 = format.parse(str3[0]);
						Date e2 = format.parse(str3[1]);
						if(s1.getTime()>e2.getTime()||e1.getTime()<s2.getTime()) {
						}else {
							throw new CourseException(ResultEnum.ILLEGAL_TIME);
						}
					}
				}
			}catch(ParseException e) {
				e.getMessage();
			}
			courseRepository.save(course);
		}else {
			throw new CourseException(ResultEnum.SAME_COMPANYNAME);
		}
	}

	public List<Course> findCoursesByPage(int page, List<Course> courses) throws CourseException {
		if (courses.isEmpty())
			throw new CourseException(ResultEnum.ITEM_NULL);

		int start = (page - 1) * PAGE_SIZE;
		int end = start + PAGE_SIZE;
		if (end > courses.size())
			end = courses.size();
		return courses.subList(start, end);
	}

	public int getLastPage(List<Course> courses) {
		return (int) Math.ceil( 1.0 * courses.size() / PAGE_SIZE );
	}
	
	public List<Course> findCourseByKeyWord(String key) throws CourseException {
		return null;
	}

	public void delCourse(String [] ns) throws Exception{
		for(String name : ns) {
			Course course = courseRepository.findByCourseNameIgnoreCase(name.trim());
			courseRepository.deleteByCourseName(name.trim());
			if(course.getLogo()!=null)
			logger.info("name." + name + " Photo delete." + ImageUtilDateBase.delImage(course.getLogo()));
		}
	}
}
