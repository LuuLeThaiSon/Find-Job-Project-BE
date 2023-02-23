package com.example.findjobbe.service;

import javax.mail.MessagingException;
import javax.mail.Multipart;

public interface EmailSender {
    void sendMail(String to, String subject, String message);

    void sendMailCandidate(String to, String subject, String messageC) throws MessagingException;

    void sendMailEmbedLink( String subject, String to, String msg);

}
