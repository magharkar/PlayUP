package com.playup.service.email;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Shiv Gaurang Desai
 */

public class EmailServiceTest {
    @Test
    public void emailServiceClassNotNullTest() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.email.EmailSenderServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }
}
