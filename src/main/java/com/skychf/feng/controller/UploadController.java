package com.skychf.feng.controller;

import com.skychf.feng.api.Result;
import com.skychf.feng.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class UploadController {
    /**
     * 文件上传
     * @param file
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/upload")
    public Result singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            return Result.error("没有选择图片");
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(file.getOriginalFilename());
            Files.write(path, bytes);
            return Result.success(path);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error("图片上传错误");
        }
    }
}
