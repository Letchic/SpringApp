package com.letchic.services;

import com.letchic.model.User;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;


@Service("findService")
public class FindUser {
    @Autowired
    private Reader reader;
    public String find(User user,HttpServletRequest request) {
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
                    user.setBrowserName(userAgent.getBrowser().getName());

                    LocalDateTime today = LocalDateTime.now();
                    ZonedDateTime zonedDateTime = ZonedDateTime.of(today, resolveZoneId(request));
                    String formattedDateTime = DateTimeFormatter
                            .ofPattern("yyyy-MM-dd HH:mm")
                            .format(zonedDateTime);
                    user.setTime(formattedDateTime);
                    return "userFound";
                }
            }
        }
        return "notFound";
}
    private ZoneId resolveZoneId(HttpServletRequest request) {
        TimeZone timeZone = RequestContextUtils.getTimeZone(request);
        return (timeZone != null ? timeZone.toZoneId() : ZoneId.systemDefault());
    }
}
