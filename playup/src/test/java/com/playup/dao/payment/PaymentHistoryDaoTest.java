package com.playup.dao.payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Shiv Gaurang Desai
 */
public class PaymentHistoryDaoTest {
    @Test
    public void paymentDaoClassNotNullTest() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.dao.payment.PaymentHistoryDaoImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }
}
