package com.playup.service.user;

import java.sql.SQLException;
import java.text.ParseException;

public interface IOneTimePasswordService {
    public String createOtp();
    public String sendOTP(String email) throws SQLException;
    public String verifyOTPForPasswordReset(String email, String oneTimePassword, String password) throws SQLException, ParseException;
    public String verifyOTP(String email, String oneTimePassword) throws SQLException, ParseException;
}
