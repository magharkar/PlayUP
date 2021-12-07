/**
 * @author Shiv Gaurang Desai
 */
package com.playup.tests.payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PaymentHistoryDaoTest {
    @Test
    public void paymentDaoTestClass() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.dao.payment.PaymentHistoryDaoImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }
}
