//@Author Mugdha Agharkar

package com.playup.service.user;

import com.playup.dao.user.IUserDao;
import com.playup.dao.user.UserProfileFactoryDao;
import com.playup.model.user.IUser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class UserRegistrationServiceImpl implements IUserRegistrationService {
    @Override
    public boolean registerNewUser(IUser user) {
        IUserDao userDao = UserProfileFactoryDao.instance().userDao();
        boolean isUserAdded = false;
        try {
            isUserAdded = userDao.addNewUser(user);
            if(isUserAdded) {
                setUserDetails(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUserAdded;
    }

    private void setUserDetails(IUser user) {
        try {
            FileInputStream in = new FileInputStream("src/main/resources/application.properties");
            Properties props = new Properties();
            props.load(in);
            in.close();
            FileOutputStream out = new FileOutputStream("src/main/resources/application.properties");
            props.setProperty("loggedInUser", user.getEmail() + "|" + user.getSport());
            props.store(out, null);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
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
