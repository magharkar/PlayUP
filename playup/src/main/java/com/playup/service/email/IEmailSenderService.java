/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.email;

public interface IEmailSenderService {
    void sendEmail(String  toEmail, String body, String subject);
}
