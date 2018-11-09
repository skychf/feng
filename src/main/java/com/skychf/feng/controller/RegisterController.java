package com.skychf.feng.controller;

import com.skychf.feng.Requests.Register;
import com.skychf.feng.api.Result;
import com.skychf.feng.entity.User;
import com.skychf.feng.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 旅游社交用户注册
 */
@RestController
public class RegisterController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public Result index(@Valid @RequestBody Register register) {
        User user = new User();
        user.setUsername(register.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(register.getPassword()));
        try {
            userRepository.save(user);
            return Result.success("注册成功");
        } catch (Exception e) {
            if (userRepository.findByUsername(register.getUsername()) != null) {
                return Result.error("用户名已经存在");
            }
            return Result.error("注册失败");
        }

    }
}
