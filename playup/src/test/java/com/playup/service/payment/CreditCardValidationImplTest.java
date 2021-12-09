/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Shiv Gaurang Desai
 */
public class CreditCardValidationImplTest {
    @Test
    public void creditCardValidationServiceClassNotNullTest() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.payment.CreditCardValidationServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }

    @Test
    void nameValidationIncorrectNameTest() {
        ICreditCardValidationService creditCardValidationService = new CreditCardValidationServiceImpl();
        boolean output = creditCardValidationService.validateName("Shiv$");
        assertFalse(output);
    }

    @Test
    void nameValidationForCorrectNameTest() {
        ICreditCardValidationService creditCardValidationService = new CreditCardValidationServiceImpl();
        boolean output = creditCardValidationService.validateName("Shiv");
        assertTrue(output);
    }

    @Test
    void cardValidationForIncorrectCardNumberTest() {
        ICreditCardValidationService creditCardValidationService = new CreditCardValidationServiceImpl();
        boolean output = creditCardValidationService.validateCardNumber("4505530142792495");
        assertFalse(output);
    }

    @Test
    void cardValidationForCorrectCardNumberTest() {
        ICreditCardValidationService creditCardValidationService = new CreditCardValidationServiceImpl();
        boolean output = creditCardValidationService.validateCardNumber("4505530142792496");
        assertTrue(output);
    }

    @Test
    void CvvValidationForIncorrectTest() {
        ICreditCardValidationService creditCardValidationService = new CreditCardValidationServiceImpl();
        boolean output = creditCardValidationService.validateCVV(2222);
        assertFalse(output);
    }

    @Test
    void CvvValidationTestForCorrectTest() {
        ICreditCardValidationService creditCardValidationService = new CreditCardValidationServiceImpl();
        boolean output = creditCardValidationService.validateCVV(222);
        assertTrue(output);
    }

    @Test
    void expiryDateValidationForIncorrectTest() {
        ICreditCardValidationService creditCardValidationService = new CreditCardValidationServiceImpl();
        boolean output = creditCardValidationService.validateDate("11/21");
        assertFalse(output);
    }

    @Test
    void expiryDateValidationForCorrectTest() {
        ICreditCardValidationService creditCardValidationService = new CreditCardValidationServiceImpl();
        boolean output = creditCardValidationService.validateDate("01/22");
        assertTrue(output);
    }
}
