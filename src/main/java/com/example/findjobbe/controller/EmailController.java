package com.example.findjobbe.controller;

import com.example.findjobbe.model.EmailMessage;
import com.example.findjobbe.model.GmailMessage;
import com.example.findjobbe.service.impl.EmailSenderImpl;
import com.example.findjobbe.service.impl.GmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;


@RestController
@CrossOrigin("*")
public class EmailController {

    @Autowired
    private EmailSenderImpl emailSender;

    @Autowired
    private GmailService gmailService;


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

    @PostMapping("/sendHtmlEmail")
    public ResponseEntity<GmailMessage> sendHtmlEmail(@RequestBody GmailMessage gmailMessage) throws MessagingException {
        gmailService.sendHtmlEmail(gmailMessage.getTo(), gmailMessage.getSubject(), gmailMessage.getHtmlContent());
        return new ResponseEntity<>(gmailMessage, HttpStatus.OK);
    }

    @PostMapping("/sendPasswordHtmlEmail")
    public ResponseEntity<GmailMessage> sendPasswordHtmlEmail(@RequestBody GmailMessage gmailMessage) throws MessagingException {
        gmailService.sendPasswordHtmlEmail(gmailMessage.getTo(), gmailMessage.getSubject(), gmailMessage.getHtmlContent(), gmailMessage.getPassword());
        return new ResponseEntity<>(gmailMessage, HttpStatus.OK);
    }


}

