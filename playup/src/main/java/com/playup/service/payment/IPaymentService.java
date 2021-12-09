package com.playup.service.payment;

import com.playup.model.payment.CreditCardModel;

/**
 * @author Shiv Gaurang Desai
 */

public interface IPaymentService {
    boolean completeTransaction(CreditCardModel creditCardModel, String amount);
}
