package com.playup.tests;

import com.playup.dao.IOneTimePasswordDao;
import com.playup.dao.OneTimePasswordDao;
import com.playup.model.OneTimePassword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class OneTimePasswordDaoTest {

    IOneTimePasswordDao oneTimePasswordDaoMockObject = mock(OneTimePasswordDao.class);
    @Test
    void setOneTimePasswordTest() throws SQLException {
        OneTimePassword oneTimePassword = new OneTimePassword();
        oneTimePassword.setEmailId("otpTesting@gmail.com");
        oneTimePassword.setUserName("testUserName");
        oneTimePassword.setOneTimePasswordDate(new Date());
        oneTimePassword.setOneTimePassword("123456");

        //ToDo- fix mail sender service

        //when(oneTimePasswordDaoMockObject.setOneTimePassword(oneTimePassword);).thenReturn(true);
        //assertTrue(oneTimePasswordDaoMockObject.setOneTimePassword(oneTimePassword);, "Error while inserting otp into database");
        //verify(oneTimePasswordDaoMockObject).setOneTimePassword(oneTimePassword);
    }

    @Test
    void testGetOtpByEmail() throws SQLException, ParseException {

        ArrayList<OneTimePassword> list = new ArrayList<>();

        OneTimePassword otp = new OneTimePassword();
        otp.setEmailId("test@gmail.com");
        otp.setOneTimePassword("123456");
        otp.setOneTimePasswordDate(new Date());

        list.add(otp);



        when(oneTimePasswordDaoMockObject.getOneTimePasswordByEmail("test@gmail.com")).thenReturn(list);
        assertEquals(oneTimePasswordDaoMockObject.getOneTimePasswordByEmail("test@gmail.com"), list, "No data present in database");
        verify(oneTimePasswordDaoMockObject).getOneTimePasswordByEmail("test@gmail.com");
    }


}
