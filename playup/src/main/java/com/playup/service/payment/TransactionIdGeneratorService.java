/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.payment;

import com.playup.dao.payment.PaymentDao;
import com.playup.dao.support.SupportDao;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

@Service
public class TransactionIdGeneratorService implements ITransactionIdGeneratorService{
    @Override
    public int generateTransactionId(int minimumTransactionId, int maximumTransactionId) {
        int transactionNumber = (int)(Math.random()*(maximumTransactionId-minimumTransactionId+1)+minimumTransactionId);
        try {
            boolean isNumberExits = SupportDao.getInstance().checkWhetherTicketNumberExists(transactionNumber);
            while(isNumberExits) {
                transactionNumber = (int)(Math.random()*(maximumTransactionId-minimumTransactionId+1)+minimumTransactionId);
                isNumberExits = PaymentDao.getInstance().checkWhetherTransactionExist(transactionNumber);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return transactionNumber;
    }
}
