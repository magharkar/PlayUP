/**
 * @author Shiv Gaurang Desai
 */
package com.playup.tests;

import com.playup.constants.ApplicationConstants;
import com.playup.service.payment.ITransactionIdGeneratorService;
import com.playup.service.payment.TransactionIdGeneratorServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionIdGeneratorTest {
    //Not Null test case
    @Test
    void TransactionIdGeneratorServiceNotNullTest() throws ClassNotFoundException {
        Class<?> classFinder = Class.forName("com.playup.service.payment.TransactionIdGeneratorServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classFinder);
    }

    //Testing for valid Ticket Number
    @Test
    void TransactionIdNumberValidTest() {
        ITransactionIdGeneratorService TransactionIdGeneratorService = new TransactionIdGeneratorServiceImpl();
        int number = TransactionIdGeneratorService.generateTransactionId(ApplicationConstants.MINIMUM_TRANSACTION_NUMBER,ApplicationConstants.MAXIMUM_TRANSACTION_NUMBER);
        assertTrue(number>=1000&&number<=10000);
    }

    //Testing for invalid Ticket Number
    @Test
    void TransactionIdNotValidTest() {
        ITransactionIdGeneratorService TransactionIdGeneratorService = new TransactionIdGeneratorServiceImpl();
        int number = TransactionIdGeneratorService.generateTransactionId(ApplicationConstants.MINIMUM_TRANSACTION_NUMBER,ApplicationConstants.MAXIMUM_TRANSACTION_NUMBER);
        assertFalse(number<1000||number>10000);
    }

}
