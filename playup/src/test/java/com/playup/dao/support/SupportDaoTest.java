package com.playup.dao.support;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Shiv Gaurang Desai
 */
public class SupportDaoTest {
    @Test
    public void supportDaoClassNotNullTest() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.dao.support.SupportDaoImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }
}
