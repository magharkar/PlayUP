package com.playup.service.user;

public interface IPasswordValidationService {
    boolean isPasswordValid(String password, String repeatedPassword);
}
