package com.skychf.feng.exceptions;

import com.skychf.feng.api.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
@RestController
public class RestControllerHandler {

    @ExceptionHandler
    public Result report(Exception e) {
        return Result.error(e.getMessage());
    }
}
