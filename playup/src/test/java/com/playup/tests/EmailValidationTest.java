package com.playup.tests;

import static org.junit.jupiter.api.Assertions.*;
import com.playup.service.EmailValidationService;
import com.playup.service.IEmailValidationService;
import org.junit.jupiter.api.Test;

public class EmailValidationTest {

    @Test
    public void emailValidationServiceTestForNotNull() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.EmailValidationService", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }

    @Test
    void emailValidationServiceTestForIncorrectEmail() {
        IEmailValidationService emailValidationService = new EmailValidationService();
        boolean output = emailValidationService.isEmailValid("shiv");
        assertFalse(output);
    }

    @Test
    void emailValidationServiceTestForCorrectEmail() {
        IEmailValidationService emailValidationService = new EmailValidationService();
        boolean output = emailValidationService.isEmailValid("shivdesai612@gmail.com");
        assertTrue(output);
    }

}
