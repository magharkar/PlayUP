/**
 * @author Shiv Gaurang Desai
 */
package com.playup.dao.payment;

import com.playup.model.payment.PaymentModel;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IPaymentHistoryDaoImpl {
    ArrayList<PaymentModel> getPaymentHistoryFromDB(String email)throws SQLException;
}
