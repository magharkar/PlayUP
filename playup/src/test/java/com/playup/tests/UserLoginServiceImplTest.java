package com.playup.tests;

import com.playup.model.user.User;
import com.playup.service.user.IUserLoginService;
import com.playup.service.user.UserLoginServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserLoginServiceImplTest {
    IUserLoginService loginServiceImplMock = mock(UserLoginServiceImpl.class);
    User user = mock(User.class);

    @Test
    void testCheckAccessService() throws SQLException {

        Model model = new ExtendedModelMap();

        when(loginServiceImplMock.verifyUser(user, model)).thenReturn(true);
//        assertEquals(loginServiceImplMock.verifyUser(user.getEmail(), model), true, model);
//        verify(loginServiceImplMock).verifyUser("mugdha.agharkar@gmail.com", model);
    }
}
