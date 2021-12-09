/**
 * @author Shiv Gaurang Desai
 */
package com.playup.tests.payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PaymentDaoImplTest {
    @Test
    public void paymentDaoClassNotNullTest() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.dao.payment.PaymentDaoImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }
}
