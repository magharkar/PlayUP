package com.playup.service.email;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Shiv Gaurang Desai
 */
public class EmailValidationServiceTest {
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
