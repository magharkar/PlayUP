package com.playup.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SupportDaoTest {

    @Test
    public void supportDAOTestClass() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.dao.SupportDao", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }



}
