/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.payment;

import com.playup.constants.ApplicationConstants;
import com.playup.dao.payment.PaymentDaoImpl;
import com.playup.model.payment.CreditCardModel;
import com.playup.model.payment.PaymentFactory;
import com.playup.model.payment.PaymentModel;
import com.playup.service.email.IEmailSenderService;
import com.playup.service.email.IGetLoggedInUserEmail;
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
    private IEmailSenderService emailSender;

    @Autowired
    private IGetLoggedInUserEmail getLoggedInUserEmail;

    public boolean completeTransaction(CreditCardModel creditCardModel) {
        PaymentModel paymentModel = PaymentFactory.getPaymentObject();
        int transactionNumber = transactionIdGeneratorService.generateTransactionId(ApplicationConstants.MINIMUM_TRANSACTION_NUMBER,ApplicationConstants.MAXIMUM_TRANSACTION_NUMBER);
        LocalDateTime currentTimeStamp = LocalDateTime.now();
        paymentModel.setTransactionId(transactionNumber);
        paymentModel.setCardNumber(cipherService.encrypt(creditCardModel.getCardNumber()));
        paymentModel.setName(creditCardModel.getName());
        paymentModel.setAmount(20);
        paymentModel.setTimeStamp(currentTimeStamp.toString());
        paymentModel.setLoggedInUserEmail(getLoggedInUserEmail.getEmail());
        try {
            boolean response = PaymentDaoImpl.getInstance().completePayment(paymentModel);
            if(response) {
                emailSender.sendEmail(paymentModel.getLoggedInUserEmail(),ApplicationConstants.BOOKING_CONFIRMATION_MAIL_BODY,ApplicationConstants.BOOKING_CONFIRMATION_MAIL_SUBJECT+paymentModel.getTransactionId());
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}


