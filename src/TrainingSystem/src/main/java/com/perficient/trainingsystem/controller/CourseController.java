package com.perficient.trainingsystem.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.perficient.trainingsystem.model.Course;
import com.perficient.trainingsystem.model.Result;
import com.perficient.trainingsystem.repository.CourseRepository;
import com.perficient.trainingsystem.service.CourseService;
import com.perficient.trainingsystem.utils.ImageUtilDateBase;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private CourseRepository courseRepository; 
	
	
	@RequestMapping(value = "/addCourse" ,method = { RequestMethod.POST})
	@ResponseBody
	public Result addCourse(@RequestParam("logo") MultipartFile logo,HttpServletRequest request) throws Exception {
		Course c = new Course();
		c.setCourseName(request.getParameter("courseName").trim());
		c.setClassHouers(request.getParameter("classHouers"));
		c.setCompanyId(request.getParameter("companyId"));
		c.setDescription(request.getParameter("description"));
		c.setPrice(request.getParameter("price"));
		c.setCourseStartTime(request.getParameter("CourseStartTime"));
		c.setSuitableCrowd(request.getParameter("faceTo"));
		c.setTeacher(request.getParameter("teacher"));
		c.setTime(request.getParameter("time"));
		c.setType(request.getParameter("type"));
		c.setLogo(ImageUtilDateBase.saveImage(logo, request));
		courseService.addCourse(c);
		System.out.println(c.toString());
		return new Result(0,"Add the course successfully!");
	}
	
	@RequestMapping(value = "/editCourse", method = { RequestMethod.POST})
	@ResponseBody
	public Course getCourseInfoByOldName(@RequestParam String oldName) throws Exception {
		Course course = courseRepository.findByCourseNameIgnoreCase(oldName);
		course.setLogo(ImageUtilDateBase.getImage(course.getLogo()));
		return course;
	}
	@RequestMapping(value = "/editCou" ,method = { RequestMethod.POST})
	@ResponseBody
	public Result updateCourseInfo(@RequestParam("logo") MultipartFile logo,HttpServletRequest request) throws Exception {
		Course c = courseRepository.findByCourseNameIgnoreCase(request.getParameter("oldName").trim());
		c.setCourseName(request.getParameter("courseName").trim());
		c.setClassHouers(request.getParameter("classHouers"));
		c.setCompanyId(request.getParameter("companyId"));
		c.setDescription(request.getParameter("description"));
		c.setPrice(request.getParameter("price"));
		c.setCourseStartTime(request.getParameter("CourseStartTime"));
		c.setSuitableCrowd(request.getParameter("faceTo"));
		c.setTeacher(request.getParameter("teacher"));
		c.setTime(request.getParameter("time"));
		c.setType(request.getParameter("type"));
		if(logo.getBytes().length != 0) {
			c.setLogo(ImageUtilDateBase.saveImage(logo, request));
		}
		courseService.addCourse(c);
		return new Result(0,"Update the courseInformation successfully!",c);
	}
}
