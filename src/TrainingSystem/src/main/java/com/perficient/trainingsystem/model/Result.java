package com.perficient.trainingsystem.model;

public class Result<T> {

    /** err code. */
    private Integer code;

    /** message */
    private String msg;

    /** detail content */
    private T data;
    
    public Result() {
    	
    }
    
    
    
    public Result(Integer code,String msg) {
    	this.msg = msg;
    	this.code = code;
    }
    
    public Result(Integer code,String msg,T data) {
    	this.msg = msg;
    	this.code = code;
    	this.data = data;
    }
    
    

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

