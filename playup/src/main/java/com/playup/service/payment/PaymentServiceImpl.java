/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.payment;

import com.playup.constants.ApplicationConstants;
import com.playup.dao.payment.PaymentDaoImpl;
import com.playup.model.payment.CreditCard;
import com.playup.model.payment.PaymentFactory;
import com.playup.model.payment.PaymentModel;
import com.playup.service.email.IEmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private ICipherService cipherService;

    @Autowired
    private ITransactionIdGeneratorService transactionIdGeneratorService;

    @Autowired
    private IEmailSender emailSender;

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
            boolean response = PaymentDaoImpl.getInstance().completePayment(paymentModel);
            if(response) {
                emailSender.sendEmail(ApplicationConstants.BOOKING_CONFIRMATION_MAIL_BODY,ApplicationConstants.BOOKING_CONFIRMATION_MAIL_SUBJECT+paymentModel.getTransactionId());
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}


