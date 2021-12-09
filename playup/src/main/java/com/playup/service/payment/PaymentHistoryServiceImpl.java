package com.playup.service.payment;

import com.playup.dao.payment.PaymentHistoryDaoImpl;
import com.playup.model.payment.PaymentModel;
import com.playup.service.email.IGetLoggedInUserEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * @author Shiv Gaurang Desai
 */

@Service
public class PaymentHistoryServiceImpl implements IPaymentHistoryService {
    private static PaymentHistoryServiceImpl paymentHistoryServiceInstance;

    private PaymentHistoryServiceImpl(){}

    public static PaymentHistoryServiceImpl getInstance () {
        if(paymentHistoryServiceInstance==null) {
            paymentHistoryServiceInstance = new PaymentHistoryServiceImpl();
            return paymentHistoryServiceInstance;
        }
        return paymentHistoryServiceInstance;
    }

    @Autowired
    IGetLoggedInUserEmail loggedInUserEmail;

    @Override
        public ArrayList<PaymentModel> fetchPaymentHistory() {
        String emailId = loggedInUserEmail.getEmail();
        ArrayList<PaymentModel> paymentHistoryList = new ArrayList<>();
        try {
            paymentHistoryList =  PaymentHistoryDaoImpl.getInstance().getPaymentHistoryFromDB(emailId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentHistoryList;
    }
}
