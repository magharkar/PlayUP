package com.playup.service.payment;

import com.playup.dao.payment.IPaymentDao;
import com.playup.dao.payment.PaymentDaoImpl;
import com.playup.model.payment.PaymentModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Shiv Gaurang Desai
 */

public class PaymentServiceImplTest {
    private IPaymentDao paymentDao = Mockito.mock(PaymentDaoImpl.class);

    @Test
    public void paymentServiceImplClassNotNullTest() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.payment.PaymentServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }
    @Test
    public void checkWhetherTransactionNumberExistsTest() throws SQLException {
        when(paymentDao.checkWhetherTransactionExist(5401)).thenReturn(true);
        boolean output = paymentDao.checkWhetherTransactionExist(5401);
        assertEquals(paymentDao.checkWhetherTransactionExist(5401),output);
    }

    @Test
    public void checkWhetherTransactionNumberNotExistsTest() throws SQLException {
        when(paymentDao.checkWhetherTransactionExist(304)).thenReturn(false);
        boolean output = paymentDao.checkWhetherTransactionExist(304);
        assertEquals(paymentDao.checkWhetherTransactionExist(304),output);
    }

    @Test
    public void checkWhetherPaymentIsCompleted() throws SQLException {
        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setName("Shiv Desai");
        paymentModel.setCardNumber("4505530142792495");
        paymentModel.setLoggedInUserEmail("shivgdesai6@gmail.com");
        paymentModel.setTimeStamp("2021-12-06T21:53:19.451");
        paymentModel.setTransactionId(5001);
        paymentModel.setAmount(20);
        when(paymentDao.completePayment(paymentModel)).thenReturn(true);
        assertEquals(paymentDao.completePayment(paymentModel), true);
        verify(paymentDao).completePayment(paymentModel);
    }
}
