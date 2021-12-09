
package com.playup.service.payment;

import com.playup.model.payment.CreditCardModel;
import com.playup.model.payment.CardFactory;
import org.springframework.stereotype.Service;

/**
 * @author Shiv Gaurang Desai
 */

@Service
public class CardFactoryServiceImpl implements ICardFactoryService {
    @Override
        public CreditCardModel getCreditCard() {
        return CardFactory.createCreditCard();
    }
}
