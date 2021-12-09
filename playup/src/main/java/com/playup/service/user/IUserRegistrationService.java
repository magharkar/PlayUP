package com.playup.service.user;

import com.playup.model.user.IUser;

/**
 * @author Mugdha Anil Agharkar
 */
public interface IUserRegistrationService {
    boolean registerNewUser(IUser user);

    boolean isUserAlreadyRegistered(IUser user);
}
