/**
 * @author Shiv Gaurang Desai
 */
package com.playup.tests.payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CardFactoryServiceImplTest {
    @Test
    public void cardFactoryServiceImplClassTest() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.payment.CardFactoryServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }
}
