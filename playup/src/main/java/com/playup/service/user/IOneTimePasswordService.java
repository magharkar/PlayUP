package com.playup.service.user;

import java.sql.SQLException;

/**
 * @author Mugdha Anil Agharkar
 */

public interface IOneTimePasswordService {
    String sendOTP(String email) throws SQLException;

    String verifyOTPForPasswordReset(String email, String oneTimePassword, String password);

    String verifyOTP(String email, String oneTimePassword);
}
