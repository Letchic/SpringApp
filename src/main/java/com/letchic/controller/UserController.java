package com.letchic.controller;

import com.letchic.model.User;
import com.letchic.services.Writter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @GetMapping("/user")
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }

    @Autowired
    private Writter writter;
    @PostMapping("/user")
    public String userSubmit(User user){
        writter.writeToCsvFile(user.getuser(),";","users.csv");
        return "userResult";
    }
}
