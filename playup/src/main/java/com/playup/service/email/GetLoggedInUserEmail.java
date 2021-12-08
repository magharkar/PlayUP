/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.email;

import com.playup.constants.ApplicationConstants;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

@Service
public class GetLoggedInUserEmail implements  IGetLoggedInUserEmail{
    @Override
    public  String getEmail() {
        String userEmail = "";
        try {
            FileInputStream in = new FileInputStream(ApplicationConstants.APPLICATION_PROPERTIES_PATH);
            Properties props = new Properties();
            props.load(in);
            in.close();
            FileOutputStream out = new FileOutputStream(ApplicationConstants.APPLICATION_PROPERTIES_PATH);
            props.store(out, null);
            userEmail = props.get("emailId").toString();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userEmail;
    }
}
