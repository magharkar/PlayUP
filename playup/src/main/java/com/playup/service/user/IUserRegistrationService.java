/**
 * @author Mugdha Anil Agharkar
 */
package com.playup.service.user;

import com.playup.model.user.IUser;

public interface IUserRegistrationService {
    boolean registerNewUser(IUser user);

    boolean isUserAlreadyRegistered(IUser user);
}
