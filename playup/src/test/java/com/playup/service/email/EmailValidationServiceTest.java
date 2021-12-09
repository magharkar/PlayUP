package com.playup.service.email;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Shiv Gaurang Desai
 */

public class EmailValidationServiceTest {
    private IEmailValidationService emailValidationService = EmailValidationServiceImpl.getInstance();
    @Test
    public void emailValidationServiceTestForNotNull() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.email.EmailValidationServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }

    @Test
    void emailValidationServiceTestForIncorrectEmail() {
        boolean output = emailValidationService.isEmailValid("shiv");
        assertFalse(output);
    }

    @Test
    void emailValidationServiceTestForCorrectEmail() {
        boolean output = emailValidationService.isEmailValid("shivdesai612@gmail.com");
        assertTrue(output);
    }
}
