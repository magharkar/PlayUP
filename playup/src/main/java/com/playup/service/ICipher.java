package com.playup.service;

public interface ICipher {

    public String encrypt(String messageToEncrypt);
    public String decrypt(String messageToDecrypt);

}
