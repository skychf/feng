package com.skychf.feng.controller;

import com.skychf.feng.api.Result;
import com.skychf.feng.entity.User;
import com.skychf.feng.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * 旅游社交用户注册
 */
@RestController
public class RegisterController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public Result index(@RequestParam("username") @NotNull String username, @RequestParam("password") String password) {

        System.err.println(username);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            userRepository.save(user);
            return Result.success("注册成功");
        } catch (Exception e) {
            return Result.error("注册失败");
        }

    }
}
