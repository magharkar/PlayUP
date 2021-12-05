/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.payment;

import com.playup.model.payment.CreditCard;
import com.playup.model.payment.CardFactory;
import org.springframework.stereotype.Service;

@Service
public class CardFactoryService implements ICardFactoryService {
    @Override
    public CreditCard getCreditCard() {
        return CardFactory.createCreditCard();
    }
}
