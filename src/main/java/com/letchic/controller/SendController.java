package com.letchic.controller;


import com.letchic.model.User;
import com.letchic.services.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;




@Controller
public class SendController {

    @Resource(name = "emailService")
    private Sender emailService;


    @PostMapping("/send")
    public String handleFileUpload(@ModelAttribute User user){
        emailService.sendPreConfiguredMail(user.getEmail());
        return "sendMail";
    }
}