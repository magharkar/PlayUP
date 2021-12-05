/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.payment;

import com.playup.model.payment.CreditCard;

public interface IPaymentService {
    boolean completeTransaction(CreditCard creditCard);
}
