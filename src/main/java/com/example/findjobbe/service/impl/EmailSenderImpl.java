package com.example.findjobbe.service.impl;

import com.example.findjobbe.service.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderImpl implements EmailSender {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendMail(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("404teamn1@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        mailSender.send(simpleMailMessage);
    }

    @Override
    public void sendMailCandidate(String to, String subject, String messageC) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("404teamn1@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(messageC);

        mailSender.send(simpleMailMessage);
    }
}
