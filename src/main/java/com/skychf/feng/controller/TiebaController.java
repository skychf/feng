package com.skychf.feng.controller;

import com.skychf.feng.api.Result;
import com.skychf.feng.entity.Tieba;
import com.skychf.feng.repository.TiebaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TiebaController {

    TiebaRepository tiebaRepository;

    @GetMapping("tieba")
    public Result index() {
        List<Tieba> tiebas = tiebaRepository.findAll();
        return Result.success(tiebas);
    }

    @PostMapping("tieba")
    public Result store(@RequestBody Tieba tieba) {
        try {
            tiebaRepository.save(tieba);
            return Result.success("增加成功");
        } catch (Exception e) {
            return Result.error("增加失败");
        }
    }
}
