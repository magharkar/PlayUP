/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.email;

import com.playup.constants.ApplicationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

@Service
public class EmailSenderServiceImpl implements IEmailSender {
    @Autowired
     JavaMailSender mailSender;

    @Override
    public void sendEmail(String toEmail, String body, String subject){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(ApplicationConstants.ADMIN_MAIL_ID);
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
    }

    public void sendEmail(String body, String subject) {
        try {
            FileInputStream in = new FileInputStream("src/main/resources/application.properties");
            Properties props = new Properties();
            props.load(in);
            in.close();
            FileOutputStream out = new FileOutputStream("src/main/resources/application.properties");
            props.store(out, null);
            sendEmail(props.get("emailId").toString(),body,subject);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
