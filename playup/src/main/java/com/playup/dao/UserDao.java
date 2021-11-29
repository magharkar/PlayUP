package com.playup.dao;

import com.playup.database.PlayupDBConnection;
import com.playup.model.IUser;
import com.playup.model.UserFactory;
import com.playup.model.UserObjectFactory;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class UserDao implements IUserDao {

    private static UserDao userDao;

    public static UserDao getInstance () {
        if(userDao==null) {
            userDao = new UserDao();
            return userDao;
        }
        return userDao;
    }

    @Override
    public IUser getUserByUserEmail(String email) throws SQLException {
      //  userName = "shiv";
        boolean isUserFound = false;
       //String query = "select * from User where city='Halifax'";
        String query = "Select * from User where email=" + "'" + email + "'";
        String sqlQuery = String.format(query);
        //String sqlQuery = String.format("select * from CSCI5308_1_DEVINT.User where city = %s;",userName);
        ResultSet resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);
        System.out.println(sqlQuery);
        IUser user = UserFactory.userObject(new UserObjectFactory());


        while (resultSet.next()) {
            user.setUserId(resultSet.getInt("user_id"));
            user.setEmail(resultSet.getString("email"));
            user.setContactNumber(resultSet.getString("phone"));
            user.setPassword(resultSet.getString("password"));
            user.setUserName(resultSet.getString("username"));
        }


//        System.out.println("RESULT");
//        ResultSetMetaData rsmd = resultSet.getMetaData();
//        int size =0;
//        while (resultSet.next()) {
//            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//                size ++;
//                if (i > 1) System.out.print(",  ");
//                String columnValue = resultSet.getString(i);
//                System.out.print(columnValue + " " + rsmd.getColumnName(i));
//            }
//            System.out.println("");
//        }
//        System.out.println(size);
        return user;
    }

    @Override
    public boolean addNewUser(IUser user) throws SQLException {
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
           boolean resultSet = PlayupDBConnection.getInstance().updateData(sqlQuery);
          return resultSet;
       }
       return false;
    }

    @Override
    public boolean isUserAlreadyRegistered(IUser user) throws SQLException {
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
