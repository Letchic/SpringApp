package com.letchic.controller;


import com.letchic.model.User;
import com.letchic.services.Reader;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class FindUserController {


    @Autowired
    private Reader reader;

    @PostMapping("/finduser")
    public String userSubmit(@ModelAttribute User user, HttpServletRequest request) {
        List<String[]> list = new ArrayList<>();
        list = reader.readFromCsvFile(";", "users.csv");
        for (String[] str : list) {
            if (user.getFirstName() != null && user.getLastName() != null) {
                if (user.getFirstName().equalsIgnoreCase(str[0]) && user.getLastName().equalsIgnoreCase(str[1])) {
                    user.setMiddleName(str[2]);
                    user.setAge(str[3]);
                    user.setSalary(str[4]);
                    user.setEmail(str[5]);
                    user.setWorkAddres(str[6]);

                    UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
                    System.out.println(userAgent.getBrowser().getName() + " " + userAgent.getBrowserVersion());
                    user.setBrowserName (userAgent.getBrowser().getName());

                    Date date = new Date();
                    //String formattedDate = dateFormat.setTimeZone(TimeZone.getTimeZone(userTimeZone));
                    return "userFound";
                }
            }
        }
        return "notFound";
    }
}
