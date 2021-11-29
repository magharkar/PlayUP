package com.playup.service;

import com.playup.dao.IUserDao;
import com.playup.dao.UserProfileDaoFactory;
import com.playup.model.IUser;

import java.sql.SQLException;

public class UserRegistrationService implements IUserRegistrationService {
    @Override
    public boolean registerNewUser(IUser user) throws SQLException {
        IUserDao userDao = UserProfileDaoFactory.instance().userDao();
        boolean isUserAdded = userDao.addNewUser(user);
        return isUserAdded;
    }

    @Override
    public boolean isUserAlreadyRegistered(IUser user) throws SQLException {
        IUserDao userDao = UserProfileDaoFactory.instance().userDao();
        boolean isUserAlreadyRegistered = userDao.isUserAlreadyRegistered(user);
        return isUserAlreadyRegistered;
    }
}
