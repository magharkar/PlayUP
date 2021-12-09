package com.playup.service.user;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OneTimePasswordServiceImplTest {

    IOneTimePasswordService otpServiceImplMock = mock(OneTimePasswordServiceImpl.class);

    @Test
    void testSendOtp() throws SQLException {

        when(otpServiceImplMock.sendOTP("test@gmail.com")).thenReturn("success");
        assertEquals(otpServiceImplMock.sendOTP("test@gmail.com"), "success", "Otp not sent");
        verify(otpServiceImplMock).sendOTP("test@gmail.com");

    }

    @Test
    void testVerifyOtp() {

        when(otpServiceImplMock.verifyOTP("test@gmail.com", "1234")).thenReturn("password_updated");
        assertEquals(otpServiceImplMock.verifyOTP("test@gmail.com", "1234"), "password_updated",
                "otp_invalid");
        verify(otpServiceImplMock).verifyOTP("test@gmail.com", "1234");

    }

    @Test
    void testVerifyOtpForPasswordReset() {

        when(otpServiceImplMock.verifyOTPForPasswordReset("test@gmail.com", "1234", "testpassword")).thenReturn("password_updated");
        assertEquals(otpServiceImplMock.verifyOTPForPasswordReset("test@gmail.com", "1234", "testpassword"), "password_updated",
                "otp_invalid");
        verify(otpServiceImplMock).verifyOTPForPasswordReset("test@gmail.com", "1234", "testpassword");

    }
}
