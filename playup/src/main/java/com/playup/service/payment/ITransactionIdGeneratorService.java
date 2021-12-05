/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.payment;

public interface ITransactionIdGeneratorService {
    int generateTransactionId(int minimumTransactionId, int maximumTransactionId);
}
