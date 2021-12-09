package com.playup.service.support;

import com.playup.dao.support.ISupportDao;
import com.playup.dao.support.SupportDaoImpl;
import com.playup.model.support.SupportModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Shiv Gaurang Desai
 */
public class SupportServiceImpl {
    ISupportDao supportDao = Mockito.mock(SupportDaoImpl.class);
    @Test
    public void cardFactoryServiceImplClassNotNullTest() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.support.SupportServiceImpl", false, getClass().getClassLoader());
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
    void checkWhetherSupportRequestIsCreatedTest() throws SQLException {
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
        verify(supportDao).generateSupportRequest(supportModel);
    }
}
