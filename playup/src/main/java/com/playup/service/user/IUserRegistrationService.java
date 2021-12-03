package com.playup.service.user;

import com.playup.model.user.IUser;

import java.sql.SQLException;

public interface IUserRegistrationService {

    public boolean registerNewUser(IUser user) throws SQLException;

    public boolean isUserAlreadyRegistered(IUser user) throws SQLException;
}
