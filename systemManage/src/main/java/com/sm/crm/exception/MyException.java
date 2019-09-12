package com.sm.crm.exception;

import com.sm.crm.entity.ExceptionEnum;

public class MyException extends RuntimeException {

    ExceptionEnum exceptionEnum;

    public MyException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }
}
