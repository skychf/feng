package com.skychf.feng.controller;

import com.skychf.feng.api.Result;
import com.skychf.feng.entity.Strategy;
import com.skychf.feng.repository.StrategyRepository;
import com.skychf.feng.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StrategyController {

    @Autowired
    StrategyRepository strategyRepository;

    /**
     * 用户发布旅游信息
     * * @param description
     * @param body
     * @param is_public
     * @return
     */
    @PostMapping("strategy")
    public Result store(@RequestParam("description") String description,
                        @RequestParam("body") String body,
                        @RequestParam("is_public") Integer is_public) {
        Strategy strategy = new Strategy();
        try {
            strategy.setDescription(description);
            strategy.setBody(body);
            strategy.setIsPublic(is_public);
            strategyRepository.save(strategy);
            return Result.success("发布成功");
        } catch (Exception e) {
            return Result.success("发布错误");
        }

    }
}
