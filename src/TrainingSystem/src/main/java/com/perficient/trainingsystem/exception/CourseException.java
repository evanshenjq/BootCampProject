package com.perficient.trainingsystem.exception;

import com.perficient.trainingsystem.enums.ResultEnum;

public class CourseException extends Exception{
	private Integer code;

    public CourseException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }

}
