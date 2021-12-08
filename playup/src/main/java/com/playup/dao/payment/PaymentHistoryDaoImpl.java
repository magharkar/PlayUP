/**
 * @author Shiv Gaurang Desai
 */
package com.playup.dao.payment;

import com.playup.constants.QueryConstants;
import com.playup.database.PlayupDBConnection;
import com.playup.model.payment.PaymentModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentHistoryDaoImpl {
    private static PaymentHistoryDaoImpl paymentHistoryDaoInstance;

    private PaymentHistoryDaoImpl(){}

    public static PaymentHistoryDaoImpl getInstance () {
        if(paymentHistoryDaoInstance==null) {
            paymentHistoryDaoInstance = new PaymentHistoryDaoImpl();
            return paymentHistoryDaoInstance;
        }
        return paymentHistoryDaoInstance;
    }

    public ArrayList<PaymentModel> getPaymentHistoryFromDB(String email) throws SQLException
    {
        ArrayList<PaymentModel> paymentHistoryList = new ArrayList<>();
        String sqlQuery = String.format(QueryConstants.FETCH_PAYMENT_HISTORY,email);
        ResultSet resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);
        while (resultSet != null && resultSet.next())
        {
            paymentHistoryList.add(new PaymentModel( Integer.parseInt(resultSet.getString("transactionId")), resultSet.getString("name"), resultSet.getString("cardNumber"), Integer.parseInt(resultSet.getString("amount")), resultSet.getString("timeStamp"), resultSet.getString("email")));
        }
        return paymentHistoryList;
    }
}
