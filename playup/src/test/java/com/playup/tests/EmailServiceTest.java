package com.playup.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.playup.model.user.OneTimePassword;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class EmailServiceTest {
    @Test
    public void emailServiceTestClass() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.email.EmailSenderServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }
}
