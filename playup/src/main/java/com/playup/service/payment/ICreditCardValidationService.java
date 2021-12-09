/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.payment;

import com.playup.model.payment.CreditCardModel;
import java.util.HashMap;

public interface ICreditCardValidationService {
    boolean validateCVV(int cvv);
    boolean validateDate(String expiryDate);
    boolean validateName(String Name);
    boolean validateCardNumber(String name);
    HashMap<Boolean,String> isCardDetailsValid(CreditCardModel creditCardModel);
}
