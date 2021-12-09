package com.playup.service.payment;

import com.playup.model.payment.PaymentModel;
import java.util.ArrayList;

/**
 * @author Shiv Gaurang Desai
 */

public interface IPaymentHistoryService {
    ArrayList<PaymentModel> fetchPaymentHistory();
}
