package com.playup.service.payment;

import com.playup.constants.ApplicationConstants;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Shiv Gaurang Desai
 */
public class TransactionIdGeneratorTest {
    @Test
        void TransactionIdGeneratorServiceNotNullTest() throws ClassNotFoundException {
        Class<?> classFinder = Class.forName("com.playup.service.payment.TransactionIdGeneratorServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classFinder);
    }

    @Test
    void TransactionIdNumberValidTest() {
        ITransactionIdGeneratorService TransactionIdGeneratorService = new TransactionIdGeneratorServiceImpl();
        int number = TransactionIdGeneratorService.generateTransactionId(ApplicationConstants.MINIMUM_TRANSACTION_NUMBER,ApplicationConstants.MAXIMUM_TRANSACTION_NUMBER);
        assertTrue(number>=1000&&number<=10000);
    }

    @Test
    void TransactionIdNotValidTest() {
        ITransactionIdGeneratorService TransactionIdGeneratorService = new TransactionIdGeneratorServiceImpl();
        int number = TransactionIdGeneratorService.generateTransactionId(ApplicationConstants.MINIMUM_TRANSACTION_NUMBER,ApplicationConstants.MAXIMUM_TRANSACTION_NUMBER);
        assertFalse(number<1000||number>10000);
    }
}
