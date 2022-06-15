package com.um.controller;

import com.um.services.FileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/storage")
public class FireController {
    @PostMapping("/profile/pic")
    public Object upload(@RequestParam("file")MultipartFile multipartFile) {
//        logger.info("HIT -/upload | File Name: {}", multipartFile.getOriginalFilename());
        return FileService.upload(multipartFile);
    }

    @PostMapping("/profile/pic/{fileName}")
    public Object download(@PathVariable String fileName) throws IOException {
//        logger.info("HIT -/download | File Name: {}", fileName);
        return FileService.download(fileName);
    }
}
