/**
 * @author Shiv Gaurang Desai
 */
package com.playup.model.payment;

public class CardFactory {
    public static CreditCardModel createCreditCard() {
        return new CreditCardModel();
    }
}
