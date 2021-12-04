//@Author Mugdha Agharkar

package com.playup.service.user;

import java.sql.SQLException;
import java.text.ParseException;

public interface IOneTimePasswordService {
    String createOtp();
    String sendOTP(String email) throws SQLException;
    String verifyOTPForPasswordReset(String email, String oneTimePassword, String password) throws SQLException, ParseException;
    String verifyOTP(String email, String oneTimePassword) throws SQLException, ParseException;
}
