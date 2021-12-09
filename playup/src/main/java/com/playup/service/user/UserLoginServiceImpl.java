/**
 * @author Mugdha Anil Agharkar
 */
package com.playup.service.user;

import com.playup.dao.user.IUserDao;
import com.playup.dao.user.UserProfileFactoryDao;
import com.playup.model.user.IUser;
import com.playup.model.user.User;
import org.springframework.ui.Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class UserLoginServiceImpl implements IUserLoginService{
    @Override
    public boolean verifyUser(User user, Model model){
        IUserDao userDao = UserProfileFactoryDao.instance().userDao();
        IUser existingUser = null;
        existingUser = userDao.getUserByUserEmail(user.getEmail());
        if(existingUser.getEmail() == null) {
            return false;
        }
        boolean isUserValid = ((existingUser.getEmail()).equals(user.getEmail())) && (existingUser.getPassword().equals(user.getPassword()));
        if(isUserValid) {
            setUserDetails(existingUser);
        }
        return isUserValid;
    }

    @Override
    public String getUserRoleByEmail(User user, Model model) {
        IUserDao userDao = UserProfileFactoryDao.instance().userDao();
        IUser existingUser = null;
        existingUser = userDao.getUserByUserEmail(user.getEmail());
        return existingUser.getRole();
    }

    private void setUserDetails(IUser user) {
        try {
            FileInputStream in = new FileInputStream("src/main/resources/application.properties");
            Properties props = new Properties();
            props.load(in);
            in.close();
            FileOutputStream out = new FileOutputStream("src/main/resources/application.properties");
            System.out.println("USER");
            System.out.println(user.getSport());
            props.setProperty("loggedInUser", user.getEmail() + "|" + user.getSport());
            props.store(out, null);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
