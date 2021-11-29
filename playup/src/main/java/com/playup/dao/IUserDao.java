package com.playup.dao;

import com.playup.model.IUser;
import com.playup.model.User;

import java.sql.SQLException;

public interface IUserDao {

    public IUser getUserByUserEmail(String email) throws SQLException;

    public boolean addNewUser(IUser user) throws SQLException;

    public boolean isUserAlreadyRegistered(IUser user) throws SQLException;

    public boolean updatePasswordAfterReset(IUser user) throws SQLException;
}
