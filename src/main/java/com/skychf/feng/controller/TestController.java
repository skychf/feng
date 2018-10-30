package com.skychf.feng.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skychf.feng.api.Result;
import com.skychf.feng.entity.User;
import com.skychf.feng.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    protected UserRepository userRepository;
    @GetMapping("/test")
    public Boolean index() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//        return passwordEncoder.encode("123456");

        return passwordEncoder.matches("123456", "$2a$10$enHTa1IhQep381jTicBKEuicxNYBsW7jFB0ZXa.QlQ72POw5EVODm");
    }

    @GetMapping("/test/user")
    public String user() {
        User user = userRepository.findByUsername("admin");
        try {
            return new ObjectMapper().writeValueAsString(Result.error("没有登录"));
        } catch (Exception e) {
            return "e";
        }

    }

    @GetMapping("/t")
    public Result t(){
        return new Result();
    }
}
