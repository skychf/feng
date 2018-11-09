package com.skychf.feng.exceptions;

import com.skychf.feng.api.Result;
import com.skychf.feng.entity.User;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.net.BindException;

@ControllerAdvice(annotations = RestController.class)
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result bindExceptionHandler(MethodArgumentNotValidException e) {
        return Result.error(e.getBindingResult().getFieldError().getDefaultMessage());
    }
}
