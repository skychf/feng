package com.skychf.feng.controller;

import com.skychf.feng.api.Result;
import com.skychf.feng.entity.User;
import com.skychf.feng.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    /**
     * 搜索用户
     * @param username
     * @return
     */
    @GetMapping("search/{username}")
    public Result search(@PathParam("username") String username) {
        User user = userRepository.findByUsername(username);

        return Result.success(user);
    }
}
