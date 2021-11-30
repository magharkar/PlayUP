package com.playup.service;

import com.playup.model.IUser;

import java.sql.SQLException;

public interface IUserRegistrationService {

    public boolean registerNewUser(IUser user) throws SQLException;

    public boolean isUserAlreadyRegistered(IUser user) throws SQLException;
}
