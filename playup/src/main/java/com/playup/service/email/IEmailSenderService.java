package com.playup.service.email;

/**
 * @author Shiv Gaurang Desai
 */
public interface IEmailSenderService {
    void sendEmail(String  toEmail, String body, String subject);
}
