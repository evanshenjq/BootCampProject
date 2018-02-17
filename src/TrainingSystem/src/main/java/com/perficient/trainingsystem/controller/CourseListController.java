package com.perficient.trainingsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.perficient.trainingsystem.model.Course;
import com.perficient.trainingsystem.model.CourseListResult;
import com.perficient.trainingsystem.model.Result;
import com.perficient.trainingsystem.repository.CourseRepository;
import com.perficient.trainingsystem.service.CourseService;
import com.perficient.trainingsystem.utils.ImageUtilDateBase;

@Controller
public class CourseListController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private CourseRepository courseRepository;

	@RequestMapping("/organization")
	@ResponseBody
	public CourseListResult showListCourse(@RequestParam int page, @RequestParam String companyId)
			throws Exception {
		Sort sort = new Sort(Direction.DESC, "id");
		if (page <= 0 || page > courseService.getLastPage(courseRepository.findBycompanyId(companyId, sort))) {
			page = 1;
		}
		
		
		List<Course> courses = courseService.findCoursesByPage(page, courseRepository.findBycompanyId(companyId, sort));
		courses = convertLogos(courses);
		return new CourseListResult(courseService.getLastPage(courseRepository.findBycompanyId(companyId, sort)), page,
				courses);
	}

	public List<Course> convertLogos(List<Course> courses) throws Exception {
		for (int i = 0; i < courses.size(); i++) {
			String filename = courses.get(i).getLogo();
			if (ImageUtilDateBase.getImage(filename) != null)
				filename = ImageUtilDateBase.getImage(filename);
			courses.get(i).setLogo(filename);
		}
		return courses;
	}
	
	@RequestMapping(value = "/delCourse", method = { RequestMethod.POST})
	@ResponseBody
	public Result delCourse(@RequestParam("courseNames") String names)throws Exception{
		String[] ns = names.split(",");
		courseService.delCourse(ns);
		return new Result(0,"Delete the course successfully!");
	}
}