package com.perficient.trainingsystem.enums;

public enum ResultEnum {
	UNKNOW_ERROR(-1, "unknow err"),
    SUCCESS(0, "success"),
    SAME_COMPANYNAME(100,"The name has already existed"),
    ITEM_NULL(500, "No item"),
    ILLEGAL_NAME(-2,"Please input a valid name!"),
    ILLEGAL_TIME(-3,"Please input correct time!"),
    ;
    
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
