package com.playup.tests;

import com.playup.dao.support.ISupportDao;
import com.playup.dao.support.SupportDaoImpl;
import com.playup.model.support.SupportModel;
import com.playup.model.user.OneTimePassword;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class SupportDaoTest {
    ISupportDao supportDao = Mockito.mock(SupportDaoImpl.class);

    @Test
    public void supportDAOTestClass() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.dao.support.SupportDaoImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }

    @Test
    public void checkWhetherTicketNumberExistsTest() throws SQLException {
        when(supportDao.checkWhetherTicketNumberExists(1001)).thenReturn(true);
        boolean output = SupportDaoImpl.getInstance().checkWhetherTicketNumberExists(1001);
        assertEquals(supportDao.checkWhetherTicketNumberExists(1001),output);
    }

    @Test
    public void checkWhetherTicketNumberNotExistsTest() throws SQLException {
        when(supportDao.checkWhetherTicketNumberExists(100)).thenReturn(false);
        boolean output = SupportDaoImpl.getInstance().checkWhetherTicketNumberExists(100);
        assertEquals(supportDao.checkWhetherTicketNumberExists(100),output);
    }

    @Test
    public void checkWhetherSupportRequestIsCreated() throws SQLException {
        when(supportDao.generateSupportRequest(new SupportModel())).thenReturn(false);
        boolean output = SupportDaoImpl.getInstance().checkWhetherTicketNumberExists(100);
        assertEquals(supportDao.checkWhetherTicketNumberExists(100),output);
    }

    /**
     * This method is in progress
     * @throws SQLException
     * @throws ParseException
     */
    @Test
    void testGetOtpByEmail() throws SQLException, ParseException {
        ArrayList<SupportModel> list = new ArrayList<>();
        SupportModel supportModel = new SupportModel();
        supportModel.setTicketNumber(1922);
        supportModel.setEmail("test@gmail.com");
        supportModel.setName("demo");
        supportModel.setVenue("dalplex");
        supportModel.setDescription("Booking is not possible");
        list.add(supportModel);
        when(supportDao.generateSupportRequest(supportModel)).thenReturn(true);
        assertEquals(supportDao.generateSupportRequest(supportModel), true);
        System.out.print(verify(supportDao).generateSupportRequest(supportModel));
    }

}
