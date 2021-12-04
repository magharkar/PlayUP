//@Author Mugdha Agharkar

package com.playup.service.user;

import com.playup.dao.user.IUserDao;
import com.playup.dao.user.UserProfileFactoryDao;
import com.playup.model.user.IUser;

import java.sql.SQLException;

public class UserRegistrationService implements IUserRegistrationService {
    @Override
    public boolean registerNewUser(IUser user) throws SQLException {
        IUserDao userDao = UserProfileFactoryDao.instance().userDao();
        boolean isUserAdded = userDao.addNewUser(user);
        return isUserAdded;
    }

    @Override
    public boolean isUserAlreadyRegistered(IUser user) throws SQLException {
        IUserDao userDao = UserProfileFactoryDao.instance().userDao();
        boolean isUserAlreadyRegistered = userDao.isUserAlreadyRegistered(user);
        return isUserAlreadyRegistered;
    }
}
