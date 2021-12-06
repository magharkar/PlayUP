package com.playup.tests;

import com.playup.dao.payment.IPaymentDao;
import com.playup.dao.payment.PaymentDaoImpl;
import com.playup.dao.support.SupportDaoImpl;
import com.playup.model.payment.PaymentModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class PaymentDaoImplTest {
    IPaymentDao paymentDao = Mockito.mock(PaymentDaoImpl.class);

    @Test
    public void paymentDAOTestClass() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.dao.payment.PaymentDaoImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }

    @Test
    public void checkWhetherTicketNumberExistsTest() throws SQLException {
        when(paymentDao.checkWhetherTransactionExist(5401)).thenReturn(true);
        boolean output = PaymentDaoImpl.getInstance().checkWhetherTransactionExist(5401);
        assertEquals(paymentDao.checkWhetherTransactionExist(5401),output);
    }

    @Test
    public void checkWhetherTicketNumberNotExistsTest() throws SQLException {
        when(paymentDao.checkWhetherTransactionExist(304)).thenReturn(false);
        boolean output = PaymentDaoImpl.getInstance().checkWhetherTransactionExist(304);
        assertEquals(paymentDao.checkWhetherTransactionExist(304),output);
    }

    @Test
    public void checkWhetherSupportRequestIsCreated() throws SQLException {
        when(paymentDao.completePayment(new PaymentModel())).thenReturn(false);
        boolean output = PaymentDaoImpl.getInstance().checkWhetherTransactionExist(304);
        assertEquals(paymentDao.checkWhetherTransactionExist(304),output);
    }
}
