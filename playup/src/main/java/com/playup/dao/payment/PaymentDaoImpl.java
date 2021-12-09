package com.playup.dao.payment;

import com.playup.constants.QueryConstants;
import com.playup.database.PlayupDBConnection;
import com.playup.model.payment.PaymentModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Shiv Gaurang Desai
 */
public class PaymentDaoImpl implements IPaymentDao{
    private static PaymentDaoImpl paymentDaoInstance;

    private PaymentDaoImpl(){}

    public static PaymentDaoImpl getInstance () {
        if(paymentDaoInstance==null) {
            paymentDaoInstance = new PaymentDaoImpl();
            return paymentDaoInstance;
        }
        return paymentDaoInstance;
    }

    @Override
    public boolean checkWhetherTransactionExist(int ticketNumber) throws SQLException {
        String sqlQuery = String.format(QueryConstants.CHECK_TRANSACTION_ID_NUMBER_QUERY,ticketNumber);
        ResultSet resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);
        if (resultSet!=null&&resultSet.next()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean completePayment(PaymentModel paymentModel) throws SQLException {
        String sqlQuery = String.format(QueryConstants.INSERT_TRANSACTION_QUERY,paymentModel.getTransactionId(),paymentModel.getName(),paymentModel.getAmount(),paymentModel.getTimeStamp(),paymentModel.getCardNumber(),paymentModel.getLoggedInUserEmail());
        return  PlayupDBConnection.getInstance().updateData(sqlQuery);
    }
}
