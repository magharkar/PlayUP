package com.playup.service.payment;

/**
 * @author Shiv Gaurang Desai
 */

public interface ITransactionIdGeneratorService {
    int generateTransactionId(int minimumTransactionId, int maximumTransactionId);
}
