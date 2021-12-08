/**
 * @author Shiv Gaurang Desai
 */
package com.playup.tests.payment;

import com.playup.service.payment.CipherServiceImpl;
import com.playup.service.payment.ICipherService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CipherServiceImplTest {
    @Test
    public void cipherServiceTestClass() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.payment.CipherServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }

    @Test
    public void cipherServiceTestForEncryption() {
        ICipherService cipherService = new CipherServiceImpl();
        String encryptedString  = cipherService.encrypt("4505530142792496");
        assertEquals("ASYBoq/ZKnnXS4B80/EI9j0eDftup3Kj9iGqwlvvwvc=",encryptedString);
    }

    @Test
    public void cipherServiceTestForDecryption() {
        ICipherService cipherService = new CipherServiceImpl();
        String encryptedString  = cipherService.decrypt("ASYBoq/ZKnnXS4B80/EI9j0eDftup3Kj9iGqwlvvwvc=");
        assertEquals("4505530142792496",encryptedString);
    }
}
