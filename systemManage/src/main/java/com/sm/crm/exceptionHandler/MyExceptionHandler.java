package com.sm.crm.exceptionHandler;

import com.sm.crm.exception.MyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class  MyExceptionHandler{

    @ExceptionHandler(value = MyException.class)
    public ResponseEntity<String> exceptionhandler(MyException e){
        return ResponseEntity.ok(e.getMessage());
    }
}
