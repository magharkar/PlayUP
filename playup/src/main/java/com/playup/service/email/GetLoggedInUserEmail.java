package com.playup.service.email;

import com.playup.constants.ApplicationConstants;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Shiv Gaurang Desai
 */

@Service
public class GetLoggedInUserEmail implements IGetLoggedInUserEmail {
    @Override
    public String getEmail() {
        String userEmail = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(ApplicationConstants.APPLICATION_PROPERTIES_PATH);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            FileOutputStream fileOutputStream = new FileOutputStream(ApplicationConstants.APPLICATION_PROPERTIES_PATH);
            properties.store(fileOutputStream, null);
            userEmail = properties.get(ApplicationConstants.EMAIL_ID_TEXT).toString();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userEmail;
    }
}
