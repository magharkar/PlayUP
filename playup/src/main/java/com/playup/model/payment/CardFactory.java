package com.playup.model.payment;

/**
 * @author Shiv Gaurang Desai
 */

public class CardFactory {
    public static CreditCardModel createCreditCard() {
        return new CreditCardModel();
    }
}
