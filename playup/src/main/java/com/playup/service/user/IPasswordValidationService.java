package com.playup.service.user;

/**
 * @author Mugdha Anil Agharkar
 */

public interface IPasswordValidationService {
    boolean isPasswordValid(String password, String repeatedPassword);
}
