package com.example.findjobbe.controller;

import com.example.findjobbe.model.EmailMessage;
import com.example.findjobbe.service.impl.EmailSenderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class EmailController {

    @Autowired
    private EmailSenderImpl emailSender;

    @PostMapping("/send-email")
    public ResponseEntity<EmailMessage> sendEmail(@RequestBody EmailMessage emailMessage) {
        emailSender.sendMail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
        return new ResponseEntity<>(emailMessage, HttpStatus.OK);
    }

    @PostMapping("/send-emailCandidate")
    public ResponseEntity<EmailMessage> sendEmailCandidate(@RequestBody EmailMessage emailMessage) {
        emailSender.sendMail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessageC());
        return new ResponseEntity<>(emailMessage, HttpStatus.OK);
    }
}
