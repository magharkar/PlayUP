package com.playup.tests;

import com.playup.dao.support.ISupportDao;
import com.playup.dao.support.SupportDao;
import com.playup.model.support.SupportModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.sql.SQLException;

public class SupportDaoTest {

    ISupportDao supportDao = Mockito.mock(SupportDao.class);

    @Test
    public void supportDAOTestClass() throws ClassNotFoundException {

        Class<?> classExists = Class.forName("com.playup.dao.support.SupportDao", false, getClass().getClassLoader());
        assertNotNull(classExists);

    }

    @Test
    public void checkWhetherTicketNumberExistsTest() throws SQLException {
        when(supportDao.checkWhetherTicketNumberExists(1001)).thenReturn(true);
        boolean output = SupportDao.getInstance().checkWhetherTicketNumberExists(1001);
        assertEquals(supportDao.checkWhetherTicketNumberExists(1001),output);
    }

    @Test
    public void checkWhetherTicketNumberNotExistsTest() throws SQLException {

        when(supportDao.checkWhetherTicketNumberExists(100)).thenReturn(false);
        boolean output = SupportDao.getInstance().checkWhetherTicketNumberExists(100);
        assertEquals(supportDao.checkWhetherTicketNumberExists(100),output);

    }

    @Test
    public void checkWhetherSupportRequestIsCreated() throws SQLException {

          when(supportDao.generateSupportRequest(new SupportModel())).thenReturn(false);
        boolean output = SupportDao.getInstance().checkWhetherTicketNumberExists(100);
        assertEquals(supportDao.checkWhetherTicketNumberExists(100),output);

    }



}
