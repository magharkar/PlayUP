package com.playup.tests;

import com.playup.service.user.IOneTimePasswordService;
import com.playup.service.user.OneTimePasswordService;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OneTimePasswordServiceTest {

    IOneTimePasswordService oneTimePasswordServiceMock = mock(OneTimePasswordService.class);

    @Test
    void testSendOtp() throws SQLException {

        when(oneTimePasswordServiceMock.sendOTP("test@gmail.com")).thenReturn("success");
        assertEquals(oneTimePasswordServiceMock.sendOTP("test@gmail.com"), "success", "Otp not sent");
        verify(oneTimePasswordServiceMock).sendOTP("test@gmail.com");

    }

    @Test
    void testVerifyOtpForPasswordReset() throws SQLException, ParseException {

        when(oneTimePasswordServiceMock.verifyOTPForPasswordReset("test@gmail.com", "1234", "testpassword")).thenReturn("password_updated");
        assertEquals(oneTimePasswordServiceMock.verifyOTPForPasswordReset("test@gmail.com", "1234", "testpassword"), "password_updated",
                "otp_invalid");
        verify(oneTimePasswordServiceMock).verifyOTPForPasswordReset("test@gmail.com", "1234", "testpassword");

    }

    @Test
    void testVerifyOtp() throws SQLException, ParseException {

        when(oneTimePasswordServiceMock.verifyOTP("test@gmail.com", "testpassword")).thenReturn("password_updated");
        assertEquals(oneTimePasswordServiceMock.verifyOTP("test@gmail.com", "testpassword"), "password_updated",
                "otp_invalid");
        verify(oneTimePasswordServiceMock).verifyOTP("test@gmail.com", "testpassword");

    }



}
