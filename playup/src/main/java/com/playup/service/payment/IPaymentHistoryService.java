/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.payment;

import com.playup.model.payment.PaymentModel;
import java.util.ArrayList;

public interface IPaymentHistoryService {
    ArrayList<PaymentModel> fetchPaymentHistory();
}
