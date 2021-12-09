package com.playup.service.payment;

/**
 * @author Shiv Gaurang Desai
 */
public interface ICipherService {
    String encrypt(String messageToEncrypt);
    String decrypt(String messageToDecrypt);
}
