/**
 * @author Shiv Gaurang Desai
 */
package com.playup.tests.payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PaymentServiceImplTest {
    @Test
    public void paymentServiceImplClassTest() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.payment.PaymentServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }
}
