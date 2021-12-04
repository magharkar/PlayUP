//@Author Mugdha Agharkar

package com.playup.service.user;

import com.playup.dao.user.IUserDao;
import com.playup.dao.user.UserProfileFactoryDao;
import com.playup.model.user.IUser;

import java.sql.SQLException;

public class UserRegistrationServiceImpl implements IUserRegistrationService {
    @Override
    public boolean registerNewUser(IUser user) {
        IUserDao userDao = UserProfileFactoryDao.instance().userDao();
        boolean isUserAdded = false;
        try {
            isUserAdded = userDao.addNewUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUserAdded;
    }

    @Override
    public boolean isUserAlreadyRegistered(IUser user) {
        IUserDao userDao = UserProfileFactoryDao.instance().userDao();
        boolean isUserAlreadyRegistered = false;
        try {
            isUserAlreadyRegistered = userDao.isUserAlreadyRegistered(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUserAlreadyRegistered;
    }
}
