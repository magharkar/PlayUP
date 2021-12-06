/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.email;

public interface IEmailSender {
    void sendEmail(String  toEmail, String body, String subject);
    void sendEmail(String body, String subject);
}
