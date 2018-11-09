package com.skychf.feng.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class Result<T> {

    private Integer status = 200;

    private String message = "";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static Result success(Object data) {
        Result result = new Result();
        result.setData(data);
        return result;
    }

    public static Result success(String message) {
        Result result = new Result();
        result.setMessage(message);
        return result;
    }

    public static Result success(String message, String token) {
        Result result = new Result();
        result.setMessage(message);
        result.setToken(token);
        return result;
    }

    public static Result error(String message) {
        Result result = new Result();
        result.setMessage(message);
        result.setStatus(400);
        return result;
    }

    public static Result error(String message, Integer code) {
        Result result = new Result();
        result.setMessage(message);
        result.setStatus(code);
        return result;
    }
}
