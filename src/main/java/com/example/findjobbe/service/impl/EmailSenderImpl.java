package com.example.findjobbe.service.impl;

import com.example.findjobbe.service.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;


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

    @Override
    public void sendMailEmbedLink(String subject, String to, String msg) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper;
            msg = URLEncoder.encode("<h1>Welcome to 404 Team</h1><br/>" + "Click here to go login page: " +
                    "<a href=\"http://localhost:4200/login\">Login Now!</a>","UTF-8") ;
            helper = new MimeMessageHelper(message, "utf-8");
            helper.setFrom("404teamn1@gmail.com");
            helper.setTo(to);
            message.setSubject(subject);
            helper.setText(msg, true);
            mailSender.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(EmailSenderImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

//    @Override
//    public void sendMailCandidate(String to, String subject, String messageC) throws MessagingException {
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper;
//        helper = new MimeMessageHelper(message, "utf-8");
//        helper.setFrom("404teamn1@gmail.com");
//        helper.setTo(to);
//        helper.setSubject(subject);
//        helper.setText(messageC);
//
//        mailSender.send(message);
//    }

}
