//@Author Mugdha Agharkar

package com.playup.service.user;

import com.playup.dao.user.IUserDao;
import com.playup.dao.user.UserProfileFactoryDao;
import com.playup.model.user.IUser;
import com.playup.model.user.User;
import org.springframework.ui.Model;

import java.sql.SQLException;

public class UserLoginServiceImpl implements IUserLoginService{
    @Override
    public boolean verifyUser(User user, Model model){
        IUserDao userDao = UserProfileFactoryDao.instance().userDao();
        IUser existingUser = null;
        try {
            existingUser = userDao.getUserByUserEmail(user.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(existingUser);
        if(existingUser.getEmail() == null) {
            return false;
        }
//        System.out.println("USER");
//        System.out.println(existingUser.getUserName());
//        System.out.println(existingUser.getPassword());
//        System.out.println(user.getUserName());
//        System.out.println(user.getPassword());
        boolean isUserValid = ((existingUser.getEmail()).equals(user.getEmail())) && (existingUser.getPassword().equals(user.getPassword()));
        System.out.println(isUserValid);
        return isUserValid;
    }
}
