package com.playup.service.user;

import com.playup.model.user.IUser;
import com.playup.model.user.UserFactory;
import com.playup.model.user.UserObjectFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class UserRegistrationServiceImplTest {
    IUserRegistrationService registrationServiceImplMock = mock(UserRegistrationServiceImpl.class);

    @Test
    void testRegisterUserServiceTrue() {

        IUser user = UserFactory.userObject(new UserObjectFactory());
        user.setUserName("mugdha");
        user.setEmail("mugdha.agharkar@gmail.com");
        user.setContactNumber("9023445566");
        user.setPassword("Mugdha@0701");
        user.setSport("Badmintopn");
        user.setCity("Halifax");

        when(registrationServiceImplMock.registerNewUser(user)).thenReturn(true);
        assertTrue(registrationServiceImplMock.registerNewUser(user), "Error");
        verify(registrationServiceImplMock).registerNewUser(user);
    }

    @Test
    void testRegisterUserServiceFalse() {

        IUser user = UserFactory.userObject(new UserObjectFactory());
        user.setUserName("mugdha");
        user.setEmail("mugdha.agharkar@gmail.com");
        user.setContactNumber("9023445566");
        user.setPassword("Mugdha@0701");
        user.setSport("Badmintopn");
        user.setCity("Halifax");

        when(registrationServiceImplMock.registerNewUser(user)).thenReturn(false);
        assertFalse(registrationServiceImplMock.registerNewUser(user), "Error");
        verify(registrationServiceImplMock).registerNewUser(user);
    }
}
