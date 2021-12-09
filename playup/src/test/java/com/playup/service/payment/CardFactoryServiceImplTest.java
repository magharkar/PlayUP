package com.playup.service.payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Shiv Gaurang Desai
 */

public class CardFactoryServiceImplTest {
    @Test
    public void cardFactoryServiceImplClassNotNullTest() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.payment.CardFactoryServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }
}
