package com.letchic.controller;

import com.letchic.model.User;
import com.letchic.services.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SendController {
    @Autowired
    Sender emailService;
    @PostMapping("/send")
    public String handleFileUpload(User user){
        emailService.sendPreConfiguredMail(user.getEmail(), user.getMessage());
        return "sendMail";
    }
}