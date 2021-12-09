package com.playup.service.payment;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Shiv Gaurang Desai
 */
@Component
public class CreditCardValidationImplTest {
    private final ICreditCardValidationService creditCardValidationService = CreditCardValidationServiceImpl.getInstance();

    @Test
    public void creditCardValidationServiceClassNotNullTest() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.payment.CreditCardValidationServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }

    @Test
    void nameValidationIncorrectNameTest() {
        boolean output = creditCardValidationService.validateName("Shiv$");
        assertFalse(output);
    }

    @Test
    void nameValidationForCorrectNameTest() {
        boolean output = creditCardValidationService.validateName("Shiv");
        assertTrue(output);
    }

    @Test
    void cardValidationForIncorrectCardNumberTest() {
        boolean output = creditCardValidationService.validateCardNumber("4505530142792495");
        assertFalse(output);
    }

    @Test
    void cardValidationForCorrectCardNumberTest() {
        boolean output = creditCardValidationService.validateCardNumber("4505530142792496");
        assertTrue(output);
    }

    @Test
    void CvvValidationForIncorrectTest() {
        boolean output = creditCardValidationService.validateCVV(2222);
        assertFalse(output);
    }

    @Test
    void CvvValidationTestForCorrectTest() {
        boolean output = creditCardValidationService.validateCVV(222);
        assertTrue(output);
    }

    @Test
    void expiryDateValidationForIncorrectTest() {
        boolean output = creditCardValidationService.validateDate("11/21");
        assertFalse(output);
    }

    @Test
    void expiryDateValidationForCorrectTest() {
        boolean output = creditCardValidationService.validateDate("01/22");
        assertTrue(output);
    }
}
