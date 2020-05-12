package com.letchic.controller;

import com.letchic.model.User;
import com.letchic.services.FindUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class FindUserController {

    @GetMapping("/finduser")
    public String userSubmit(Model model) {
        return "notFound";
    }

    @Autowired
    FindUser findService;
    @PostMapping("/finduser")
    public String userSubmit(User user, HttpServletRequest request) {
        return findService.find(user, request);
    }
}