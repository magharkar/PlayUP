package com.playup.dao.user;

import com.playup.model.user.IUser;

import java.sql.SQLException;

public interface IUserDao {

    public IUser getUserByUserEmail(String email) throws SQLException;

    public boolean addNewUser(IUser user) throws SQLException;

    public boolean isUserAlreadyRegistered(IUser user) throws SQLException;

    public boolean updatePasswordAfterReset(IUser user) throws SQLException;
}
