package com.playup.service.support;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Shiv Gaurang Desai
 */

public class SupportFactoryServiceImplTest {
    @Test
    public void supportFactoryServiceImplClassNotNullTest() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.support.SupportFactoryServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }
}
