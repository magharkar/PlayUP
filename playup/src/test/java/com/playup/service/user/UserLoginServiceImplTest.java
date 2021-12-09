package com.playup.service.user;

import com.playup.model.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserLoginServiceImplTest {
    IUserLoginService loginServiceImplMock = mock(IUserLoginService.class);
    User user = mock(User.class);

    @Test
    boolean testCheckAccessService() {
        Model model = new ExtendedModelMap();
        when(loginServiceImplMock.verifyUser(user, model)).thenReturn(true);
        assertEquals(loginServiceImplMock.verifyUser(user, model), true, "success");
        verify(loginServiceImplMock).verifyUser(user, model);
        return true;
    }

    @Test
    String testGetUserRoleByEmail() {
        Model model = new ExtendedModelMap();
        when(loginServiceImplMock.getUserRoleByEmail(user, model)).thenReturn("customer");
        assertEquals(loginServiceImplMock.getUserRoleByEmail(user, model), true, "success");
        verify(loginServiceImplMock).getUserRoleByEmail(user, model);
        return "customer";
    }

}
