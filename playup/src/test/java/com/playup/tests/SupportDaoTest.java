package com.playup.tests;

import com.playup.dao.SupportDao;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SupportDaoTest {

    @Test
    public void supportDAOTestClass() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.dao.SupportDao", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }

    @Test
    public void checkWhetherTicketNumberExistsTest() throws SQLException {
      boolean output =  SupportDao.getInstance().checkWhetherTicketNumberExists(1001);
      assertEquals(true, output);
    }


}
