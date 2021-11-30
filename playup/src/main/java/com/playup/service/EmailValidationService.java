package com.playup.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidationService implements IEmailValidationService {


    @Override
    public boolean isEmailValid(String email) {

        boolean isSpecialCharacterPresent = false;
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);
        isSpecialCharacterPresent = m.find();
        return isSpecialCharacterPresent;

    }
}
