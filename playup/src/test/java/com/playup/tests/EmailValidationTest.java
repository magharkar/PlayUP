package com.playup.tests;

import static org.junit.jupiter.api.Assertions.*;
import com.playup.service.email.EmailValidationServiceImpl;
import com.playup.service.email.IEmailValidationService;
import org.junit.jupiter.api.Test;

public class EmailValidationTest {

    @Test
    public void emailValidationServiceTestForNotNull() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.email.EmailValidationServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }

    @Test
    void emailValidationServiceTestForIncorrectEmail() {
        IEmailValidationService emailValidationService = new EmailValidationServiceImpl();
        boolean output = emailValidationService.isEmailValid("shiv");
        assertFalse(output);
    }

    @Test
    void emailValidationServiceTestForCorrectEmail() {
        IEmailValidationService emailValidationService = new EmailValidationServiceImpl();
        boolean output = emailValidationService.isEmailValid("shivdesai612@gmail.com");
        assertTrue(output);
    }

}
