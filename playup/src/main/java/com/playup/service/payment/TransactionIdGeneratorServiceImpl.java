/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.payment;

import com.playup.dao.payment.PaymentDaoImpl;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

@Service
public class TransactionIdGeneratorServiceImpl implements ITransactionIdGeneratorService{
    @Override
    public int generateTransactionId(int minimumTransactionId, int maximumTransactionId) {
        int transactionNumber = (int)(Math.random()*(maximumTransactionId-minimumTransactionId+1)+minimumTransactionId);
        try {
            boolean isNumberExits = PaymentDaoImpl.getInstance().checkWhetherTransactionExist(transactionNumber);
            while(isNumberExits) {
                transactionNumber = (int)(Math.random()*(maximumTransactionId-minimumTransactionId+1)+minimumTransactionId);
                isNumberExits = PaymentDaoImpl.getInstance().checkWhetherTransactionExist(transactionNumber);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return transactionNumber;
    }
}
