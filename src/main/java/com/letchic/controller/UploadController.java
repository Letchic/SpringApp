package com.letchic.controller;

import com.letchic.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    @PostMapping("/upload")
    public String handleFileUpload(User user, @RequestParam("file") MultipartFile file){
        user.setResult(user.readFromCsvFile(file));
        return "userResult";
    }
}