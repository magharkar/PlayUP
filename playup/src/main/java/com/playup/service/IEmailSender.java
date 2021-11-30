package com.playup.service;

public interface IEmailSender {

    void sendEmail(String  toEmail, String body, String subject);


}
