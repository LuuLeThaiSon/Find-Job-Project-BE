package com.example.findjobbe.model;


import java.util.Random;


public class EmailMessage {

    private String to;
    private String subject;
    private String message;

    private String messageC;

    private String link;



    public EmailMessage(String to, String subject, String message, String messageC, String link) {
        this.to = to;
        this.subject = subject;
        this.message = message;
        this.messageC = messageC;
        this.link = link;

    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return generateString;

    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    int leftLimit = 97;

    int rightLimit = 122;

    int targetStringLength = 8;

    Random random = new Random();

    String generateString = random.ints(leftLimit, rightLimit +1)
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();

    public String getMessageC() {
        return messageC;
    }

    public void setMessageC(String messageC) {
        this.messageC = messageC;
    }

}
