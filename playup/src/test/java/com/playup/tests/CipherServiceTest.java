package com.playup.tests;

import com.playup.service.payment.CipherServiceImpl;
import com.playup.service.payment.ICipherService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;



public class CipherServiceTest {

    ICipherService supportDao = Mockito.mock(CipherServiceImpl.class);


    @Test
    public void cipherServiceTestClass() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.payment.CipherServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }

    @Test
    public void cipherServiceTestForEncryption() {

    }

}
