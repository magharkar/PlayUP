//@Author Mugdha Agharkar

package com.playup.dao.user;

import com.playup.model.user.IUser;

import java.sql.SQLException;

public interface IUserDao {

    IUser getUserByUserEmail(String email) throws SQLException;

    boolean addNewUser(IUser user) throws SQLException;

    boolean isUserAlreadyRegistered(IUser user) throws SQLException;

    boolean updatePasswordAfterReset(IUser user) throws SQLException;
}
