package com.perficient.trainingsystem.handler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.perficient.trainingsystem.enums.ResultEnum;
import com.perficient.trainingsystem.exception.CompanyException;
import com.perficient.trainingsystem.exception.CourseException;
import com.perficient.trainingsystem.model.Result;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GlobleExceptionHandlerTest {
	
	@Autowired
	GlobleExceptionHandler handler;
	@Test
	public void testOne() {
		ResultEnum re = ResultEnum.SUCCESS;
		CompanyException e = new CompanyException(re);	
		e.setCode(0);
		Result result = new Result();
		result.setCode(0);
		result.setMsg("success");
		assertEquals(result.getCode(),handler.handle(e).getCode());	
	}

	@Test
	public void testTwo() {
		ResultEnum re = ResultEnum.SUCCESS;
		CourseException e = new CourseException(re);	
		e.setCode(0);
		Result result = new Result();
		result.setCode(0);
		result.setMsg("success");
		assertEquals(result.getCode(),handler.handle(e).getCode());	
	}
	
	@Test
	public void testThree() {
		
		Result result = new Result();
		Exception e = new Exception();
		result.setCode(-1);
		result.setMsg("unknow err");
		assertEquals(result.getCode(),handler.handle(e).getCode());	
	}
}
