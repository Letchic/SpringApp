package com.letchic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service("emailService")
public class Sender
{
    @Autowired
    public JavaMailSender mailSender;
    public void sendPreConfiguredMail(String to)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("diman_pakhomov@mail.ru");
        mailMessage.setFrom("poorleno11@gmail.com");
        mailMessage.setSubject("Important email");
        mailMessage.setText("Test. Check");
        mailSender.send(mailMessage);
    }
}