/**
 * @author Shiv Gaurang Desai
 */
package com.playup.tests.support;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SupportFactoryServiceImplTest {
    @Test
    public void supportFactoryServiceImplClassTest() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.support.SupportFactoryServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }
}
