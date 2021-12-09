package com.playup.dao.payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Shiv Gaurang Desai
 */
public class PaymentDaoImplTest {
    @Test
    public void paymentDaoClassNotNullTest() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.dao.payment.PaymentDaoImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }
}
