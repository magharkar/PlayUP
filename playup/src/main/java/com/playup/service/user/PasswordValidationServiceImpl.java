package com.playup.service.user;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Mugdha Anil Agharkar
 */
@Service
public class PasswordValidationServiceImpl implements IPasswordValidationService {
    char singlePasswordCharacter;

    //Password should be at-least 8 characters long,
    // with 1 capital letter and 1  of the special characters - (@#$%^&*)

    public boolean isPasswordValid(String userPassword, String password) {
        boolean isPasswordLengthValid = password.length() >= 8;
        boolean isCapitalLetterPresent = false;
        boolean isSpecialCharacterPresent = false;
        boolean isPasswordMatched = userPassword.equals(password);

        Pattern p = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");
        Matcher m = p.matcher(password);
        isSpecialCharacterPresent = m.find();

        for(int i=0;i < password.length();i++) {
            singlePasswordCharacter = password.charAt(i);
            if (Character.isUpperCase(singlePasswordCharacter)) {
                isCapitalLetterPresent = true;
            }
        }
        return isPasswordLengthValid && isCapitalLetterPresent && isSpecialCharacterPresent && isPasswordMatched;
    }

}
