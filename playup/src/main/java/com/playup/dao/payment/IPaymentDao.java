package com.playup.dao.payment;

import com.playup.model.payment.PaymentModel;
import java.sql.SQLException;

/**
 * @author Shiv Gaurang Desai
 */

public interface IPaymentDao {
    boolean checkWhetherTransactionExist(int ticketNumber) throws SQLException;
    boolean completePayment(PaymentModel paymentModel) throws SQLException;
}
