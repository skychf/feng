package com.skychf.feng.controller;

import com.skychf.feng.api.Result;
import com.skychf.feng.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    @PostMapping("/upload")
    @ResponseBody
    public Result index(@RequestParam("file") MultipartFile file) {

        System.err.println(file.getContentType());
        System.err.println(FileUtil.getFileType(file));



        return Result.error("dd");
    }

    @GetMapping("/upload")
    public String upload() {
        return "index/index";
    }
}
