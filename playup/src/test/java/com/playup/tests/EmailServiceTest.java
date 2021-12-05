package com.playup.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EmailServiceTest {

    @Test
    public void emailServiceTestClass() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.email.EmailSenderService", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }

}
