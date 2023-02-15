package com.example.findjobbe.service;

public interface EmailSender {
    void sendMail(String to, String subject, String message);
}
