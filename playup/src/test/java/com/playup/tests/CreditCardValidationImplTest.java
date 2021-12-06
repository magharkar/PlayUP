/**
 * @author Shiv Gaurang Desai
 */
package com.playup.tests;

import com.playup.service.payment.CreditCardValidationServiceImpl;
import com.playup.service.payment.ICreditCardValidationService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreditCardValidationImplTest {

    @Test
    public void creditCardValidationServiceTestForNotNull() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.payment.CreditCardValidationServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }

    @Test
    void nameValidationTestForIncorrectName() {
        ICreditCardValidationService creditCardValidationService = new CreditCardValidationServiceImpl();
        boolean output = creditCardValidationService.validateName("Shiv$");
        assertFalse(output);
    }

    @Test
    void nameValidationTestForCorrectName() {
        ICreditCardValidationService creditCardValidationService = new CreditCardValidationServiceImpl();
        boolean output = creditCardValidationService.validateName("Shiv");
        assertTrue(output);
    }

    @Test
    void nameValidationTestForIncorrectCardNumber() {
        ICreditCardValidationService creditCardValidationService = new CreditCardValidationServiceImpl();
        boolean output = creditCardValidationService.validateCardNumber("4505530142792495");
        assertFalse(output);
    }

    @Test
    void nameValidationTestForCorrectCardNumber() {
        ICreditCardValidationService creditCardValidationService = new CreditCardValidationServiceImpl();
        boolean output = creditCardValidationService.validateCardNumber("4505530142792496");
        assertTrue(output);
    }

    @Test
    void nameValidationTestForIncorrectCvv() {
        ICreditCardValidationService creditCardValidationService = new CreditCardValidationServiceImpl();
        boolean output = creditCardValidationService.validateCVV(2222);
        assertFalse(output);
    }

    @Test
    void nameValidationTestForCorrectCvv() {
        ICreditCardValidationService creditCardValidationService = new CreditCardValidationServiceImpl();
        boolean output = creditCardValidationService.validateCVV(222);
        assertTrue(output);
    }

    @Test
    void nameValidationTestForIncorrectExpiryDate() {
        ICreditCardValidationService creditCardValidationService = new CreditCardValidationServiceImpl();
        boolean output = creditCardValidationService.validateDate("11/21");
        assertFalse(output);
    }

    @Test
    void nameValidationTestFoCorrectExpiryDate() {
        ICreditCardValidationService creditCardValidationService = new CreditCardValidationServiceImpl();
        boolean output = creditCardValidationService.validateDate("01/22");
        assertTrue(output);
    }
}
