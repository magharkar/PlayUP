package com.playup.service.payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Shiv Gaurang Desai
 */
public class CipherServiceImplTest {
    private final ICipherService cipherService = CipherServiceImpl.getInstance();
    @Test
    public void cipherServiceClassForNotNull() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.payment.CipherServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }

    @Test
    public void cipherServiceEncryptionTest() {
        String encryptedString  = cipherService.encrypt("4505530142792496");
        assertEquals("ASYBoq/ZKnnXS4B80/EI9j0eDftup3Kj9iGqwlvvwvc=",encryptedString);
    }

    @Test
    public void cipherServiceDecryptionTest() {
        String encryptedString  = cipherService.decrypt("ASYBoq/ZKnnXS4B80/EI9j0eDftup3Kj9iGqwlvvwvc=");
        assertEquals("4505530142792496",encryptedString);
    }
}
