package com.playup.tests;

import com.playup.model.IUser;
import com.playup.model.User;
import com.playup.service.IUserLoginService;
import com.playup.service.UserLoginService;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserLoginServiceTest {
    IUserLoginService loginServiceImplMock = mock(UserLoginService.class);
    User user = mock(User.class);

    @Test
    void testCheckAccessService() throws SQLException {

        Model model = new ExtendedModelMap();

        when(loginServiceImplMock.verifyUser(user, model)).thenReturn(true);
//        assertEquals(loginServiceImplMock.verifyUser(user.getEmail(), model), true, model);
//        verify(loginServiceImplMock).verifyUser("mugdha.agharkar@gmail.com", model);
    }
}
