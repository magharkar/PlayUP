/**
 * @author Mugdha Anil Agharkar
 */
package com.playup.service.user;

import java.sql.SQLException;

public interface IOneTimePasswordService {
    String sendOTP(String email) throws SQLException;

    String verifyOTPForPasswordReset(String email, String oneTimePassword, String password);

    String verifyOTP(String email, String oneTimePassword);
}
