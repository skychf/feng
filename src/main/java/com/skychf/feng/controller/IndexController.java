package com.skychf.feng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index/index";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user() {
        return "user";
    }
}
