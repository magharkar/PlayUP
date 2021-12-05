/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.payment;

public interface ICipherService {
    String encrypt(String messageToEncrypt);
    String decrypt(String messageToDecrypt);
}
