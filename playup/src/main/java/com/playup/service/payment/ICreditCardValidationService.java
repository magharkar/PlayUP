package com.playup.service.payment;

import com.playup.model.payment.CreditCardModel;
import java.util.HashMap;

/**
 * @author Shiv Gaurang Desai
 */

public interface ICreditCardValidationService {
    boolean validateCVV(int cvv);
    boolean validateDate(String expiryDate);
    boolean validateName(String Name);
    boolean validateCardNumber(String name);
    HashMap<Boolean,String> isCardDetailsValid(CreditCardModel creditCardModel);
}
