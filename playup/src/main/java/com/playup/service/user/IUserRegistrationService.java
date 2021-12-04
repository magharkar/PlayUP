//@Author Mugdha Agharkar

package com.playup.service.user;

import com.playup.model.user.IUser;

import java.sql.SQLException;

public interface IUserRegistrationService {

    boolean registerNewUser(IUser user) throws SQLException;

    boolean isUserAlreadyRegistered(IUser user) throws SQLException;
}
