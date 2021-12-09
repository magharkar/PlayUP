package com.playup.service.payment;

import com.playup.dao.payment.PaymentDaoImpl;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

/**
 * @author Shiv Gaurang Desai
 */
@Service
public class TransactionIdGeneratorServiceImpl implements ITransactionIdGeneratorService{
    @Override
    public int generateTransactionId(int minimumTransactionId, int maximumTransactionId) {
        int transactionId = (int)(Math.random()*(maximumTransactionId-minimumTransactionId+1)+minimumTransactionId);
        try {
            boolean isNumberExits = PaymentDaoImpl.getInstance().checkWhetherTransactionExist(transactionId);
            while(isNumberExits) {
                transactionId = (int)(Math.random()*(maximumTransactionId-minimumTransactionId+1)+minimumTransactionId);
                isNumberExits = PaymentDaoImpl.getInstance().checkWhetherTransactionExist(transactionId);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return transactionId;
    }
}
