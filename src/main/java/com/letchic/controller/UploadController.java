package com.letchic.controller;



import com.letchic.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UploadController {

    @PostMapping("/upload")
    public String handleFileUpload(@ModelAttribute User user, @RequestParam("file") MultipartFile file, HttpServletResponse resp){
        user.readFromCsvFile(file);
        return "userResult";
    }
}