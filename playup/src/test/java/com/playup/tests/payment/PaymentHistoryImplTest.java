/**
 * @author Shiv Gaurang Desai
 */
package com.playup.tests.payment;

import com.playup.dao.payment.IPaymentHistoryDaoImpl;
import com.playup.dao.payment.PaymentHistoryDaoImpl;
import com.playup.model.payment.PaymentModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PaymentHistoryImplTest {
    IPaymentHistoryDaoImpl paymentHistoryDao = Mockito.mock(PaymentHistoryDaoImpl.class);

    @Test
    public void paymentHistoryImplClassNotNullTest() throws ClassNotFoundException {
        Class<?> classExists = Class.forName("com.playup.service.payment.PaymentHistoryServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classExists);
    }

    @Test
    void paymentHistoryTest() throws SQLException {
        ArrayList<PaymentModel> list = new ArrayList<>();
        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setTransactionId(5401);
        paymentModel.setAmount(20);
        paymentModel.setTimeStamp("2021-12-06T21:53:19.451");
        paymentModel.setLoggedInUserEmail("shivgdesai6@gmail.com");
        paymentModel.setCardNumber("ASYBoq/ZKnnXS4B80/EI9j0eDftup3Kj9iGqwlvvwvc=");
        paymentModel.setName("Shiv Desai");
        list.add(paymentModel);
        when(paymentHistoryDao.getPaymentHistoryFromDB("shivgdesai6@gmail.com")).thenReturn(list);
        assertEquals(paymentHistoryDao.getPaymentHistoryFromDB("shivgdesai6@gmail.com"), list);
        verify(paymentHistoryDao).getPaymentHistoryFromDB("shivgdesai6@gmail.com");
    }
}
