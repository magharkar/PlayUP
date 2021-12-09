package com.playup.dao.payment;

import com.playup.constants.QueryConstants;
import com.playup.database.PlayupDBConnection;
import com.playup.model.payment.PaymentModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Shiv Gaurang Desai
 */
public class PaymentHistoryDaoImpl implements IPaymentHistoryDaoImpl{
    private static PaymentHistoryDaoImpl paymentHistoryDaoInstance;

    private PaymentHistoryDaoImpl(){}

    public static PaymentHistoryDaoImpl getInstance () {
        if(paymentHistoryDaoInstance==null) {
            paymentHistoryDaoInstance = new PaymentHistoryDaoImpl();
            return paymentHistoryDaoInstance;
        }
        return paymentHistoryDaoInstance;
    }

    @Override
    public ArrayList<PaymentModel> getPaymentHistoryFromDB(String email) throws SQLException {
        ArrayList<PaymentModel> paymentHistoryList = new ArrayList<>();
        String sqlQuery = String.format(QueryConstants.FETCH_PAYMENT_HISTORY,email);
        ResultSet resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);
        while (resultSet != null && resultSet.next())
        {
            paymentHistoryList.add(new PaymentModel( Integer.parseInt(resultSet.getString(QueryConstants.PAYMENT_QUERY_TRANSACTION_ID)), resultSet.getString(QueryConstants.PAYMENT_QUERY_NAME), resultSet.getString(QueryConstants.PAYMENT_QUERY_CARD_NUMBER), Integer.parseInt(resultSet.getString(QueryConstants.PAYMENT_QUERY_AMOUNT)), resultSet.getString(QueryConstants.PAYMENT_QUERY_TIME_STAMP), resultSet.getString(QueryConstants.PAYMENT_QUERY_EMAIL)));

        }
        return paymentHistoryList;
    }
}
