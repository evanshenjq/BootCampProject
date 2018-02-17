package com.perficient.trainingsystem.handler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.perficient.trainingsystem.exception.CompanyException;
import com.perficient.trainingsystem.exception.CourseException;
import com.perficient.trainingsystem.model.Result;
import com.perficient.trainingsystem.utils.ResultUtil;
@ControllerAdvice
public class GlobleExceptionHandler {
//	@ResponseBody
//	@ExceptionHandler(Exception.class)
//	public Map<String,Object> exceptionHandler() {
//		Map<String,Object> result = new HashMap<String,Object>();
//		result.put("code", 500);
//		result.put("msg", "It occured a question");
//		return result;
//	}
	
	@ExceptionHandler(value = Exception.class)
    @ResponseBody
	public Result handle(Exception e) {
		if(e instanceof CompanyException) {
			CompanyException companyException = (CompanyException) e;
			return ResultUtil.error(companyException.getCode(),companyException.getMessage());
		}else if(e instanceof CourseException) {
			CourseException courseException = (CourseException) e;
			return ResultUtil.error(courseException.getCode(),courseException.getMessage());
		}else {
            return ResultUtil.error(-1, "unknow err");
		}
	}
}
