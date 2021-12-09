/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.payment;

import com.playup.model.payment.CreditCardModel;

public interface IPaymentService {
    boolean completeTransaction(CreditCardModel creditCardModel);
}
