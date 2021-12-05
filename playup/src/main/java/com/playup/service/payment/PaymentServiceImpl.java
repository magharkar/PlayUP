/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.payment;

import com.playup.constants.ApplicationConstants;
import com.playup.dao.payment.PaymentDaoImpl;
import com.playup.model.payment.CreditCard;
import com.playup.model.payment.PaymentFactory;
import com.playup.model.payment.PaymentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private ICipherService cipherService;
    @Autowired
    private ITransactionIdGeneratorService transactionIdGeneratorService;
    public boolean completeTransaction(CreditCard creditCard) {
        PaymentModel paymentModel = PaymentFactory.getPaymentObject();
        int transactionNumber = transactionIdGeneratorService.generateTransactionId(ApplicationConstants.MINIMUM_TRANSACTION_NUMBER,ApplicationConstants.MAXIMUM_TRANSACTION_NUMBER);
        LocalDateTime currentTimeStamp = LocalDateTime.now();
        paymentModel.setTransactionId(transactionNumber);
        paymentModel.setCardNumber(cipherService.encrypt(creditCard.getCardNumber()));
        paymentModel.setName(creditCard.getName());
        paymentModel.setAmount(20);
        paymentModel.setTimeStamp(currentTimeStamp.toString());
        try {
            return PaymentDaoImpl.getInstance().completePayment(paymentModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
