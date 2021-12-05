//@Author Mugdha Agharkar

package com.playup.dao.user;

import com.playup.database.PlayupDBConnection;
import com.playup.model.user.IUser;
import com.playup.model.user.UserFactory;
import com.playup.model.user.UserObjectFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {

    private static UserDaoImpl userDaoImpl;

    public static UserDaoImpl getInstance () {
        if(userDaoImpl ==null) {
            userDaoImpl = new UserDaoImpl();
            return userDaoImpl;
        }
        return userDaoImpl;
    }

    @Override
    public IUser getUserByUserEmail(String email) {
      //  userName = "shiv";
        boolean isUserFound = false;
       //String query = "select * from User where city='Halifax'";
        String query = "Select * from User where email=" + "'" + email + "'";
        String sqlQuery = String.format(query);
        //String sqlQuery = String.format("select * from CSCI5308_1_DEVINT.User where city = %s;",userName);
        ResultSet resultSet = null;
        try {
            resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);
            System.out.println(sqlQuery);
            IUser user = UserFactory.userObject(new UserObjectFactory());


            while (resultSet.next()) {
                user.setUserId(resultSet.getInt("user_id"));
                user.setEmail(resultSet.getString("email"));
                user.setContactNumber(resultSet.getString("phone"));
                user.setPassword(resultSet.getString("password"));
                user.setUserName(resultSet.getString("username"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return null;
    }

    @Override
    public boolean addNewUser(IUser user) {
        boolean isUserAlreadyRegistered = isUserAlreadyRegistered(user);
        String email = user.getEmail();
        String phone = user.getContactNumber();
        String password = user.getPassword();
        String city = user.getCity();
        String username = user.getUserName();

       if(!isUserAlreadyRegistered) {
           String query = "Insert into User (email, phone, password, city, username) values " +
                   "('" + email + "'," + "'" + phone + "'," + "'" + password + "'," + "'" + city + "','" + username + "' )";
           String sqlQuery = String.format(query);
           System.out.println(sqlQuery);
           boolean resultSet = false;
           try {
               resultSet = PlayupDBConnection.getInstance().updateData(sqlQuery);
           } catch (SQLException e) {
               e.printStackTrace();
           }
           return resultSet;
       }
       return false;
    }

    @Override
    public boolean isUserAlreadyRegistered(IUser user) {
        IUser existingUser = getUserByUserEmail(user.getEmail());
        boolean isUserAlreadyRegistered = existingUser.getEmail() != null;
        return isUserAlreadyRegistered;
    }

    @Override
    public boolean updatePasswordAfterReset(IUser user) throws SQLException {
        String email = user.getEmail();
        String password = user.getPassword();

        String query = "Update User SET password=" + "'" + password + "'" + "WHERE email="
                + "'" + email + "'";
        String sqlQuery = String.format(query);
        System.out.println(sqlQuery);
        boolean resultSet = PlayupDBConnection.getInstance().updateData(sqlQuery);
        return resultSet;
    }
}
