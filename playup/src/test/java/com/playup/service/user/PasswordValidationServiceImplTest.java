package com.playup.service.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PasswordValidationServiceImplTest {

    IPasswordValidationService passwordValidationService = mock(PasswordValidationServiceImpl.class);

    @Test
    boolean testVerifyOtpForPasswordReset() {
        when(passwordValidationService.isPasswordValid("Mugdha@0701", "Mugdha@0701")).thenReturn(true);
        assertEquals(passwordValidationService.isPasswordValid("Mugdha@0701", "Mugdha@0701"), "password_updated",
                "otp_invalid");
        verify(passwordValidationService).isPasswordValid("Mugdha@0701", "Mugdha@0701");
        return true;
    }
}
