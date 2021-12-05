/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.payment;

import com.playup.model.payment.CreditCard;

public interface ICreditCardValidationService {
    boolean validateCVV(int  cvv);
    boolean validateDate(String expiryDate);
    boolean validateName(String Name);
    boolean validateCardNumber(String name);
    boolean isCardDetailsValid(CreditCard creditCard);
}
