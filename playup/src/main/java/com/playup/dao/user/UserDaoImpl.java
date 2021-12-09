package com.playup.dao.user;

import com.playup.constants.ApplicationConstants;
import com.playup.constants.QueryConstants;
import com.playup.database.PlayupDBConnection;
import com.playup.model.user.IUser;
import com.playup.model.user.UserFactory;
import com.playup.model.user.UserObjectFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Mugdha Anil Agharkar
 */

public class UserDaoImpl implements IUserDao {
    private static UserDaoImpl userDaoImpl;
    private final String COMMA = QueryConstants.QUERY_SEPERATOR;
    private final String WHERE_CLAUSE = "'WHERE email='";
    private final String SINGLE_QUOTE = "'";

    public static UserDaoImpl getInstance () {
        if(userDaoImpl ==null) {
            userDaoImpl = new UserDaoImpl();
            return userDaoImpl;
        }
        return userDaoImpl;
    }

    @Override
    public IUser getUserByUserEmail(String email) {
        String query = QueryConstants.SELECT_USER + email + SINGLE_QUOTE;
        String sqlQuery = String.format(query);
        ResultSet resultSet = null;
        try {
            resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);
            IUser user = UserFactory.userObject(new UserObjectFactory());

            while (resultSet.next()) {
                user.setUserId(resultSet.getInt(ApplicationConstants.USER_ID));
                user.setEmail(resultSet.getString(ApplicationConstants.EMAIL));
                user.setContactNumber(resultSet.getString(ApplicationConstants.PHONE));
                user.setPassword(resultSet.getString(ApplicationConstants.PASSWORD));
                user.setUserName(resultSet.getString(ApplicationConstants.USERNAME));
                user.setCity(resultSet.getString(ApplicationConstants.CITY));
                user.setSport(resultSet.getString(ApplicationConstants.SPORT));
                user.setRole(resultSet.getString(ApplicationConstants.ROLE));
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
        String sport = user.getSport();

       if(!isUserAlreadyRegistered) {
           String query = QueryConstants.INSERT_USER + "('" + email + COMMA + phone + COMMA + password +
                   COMMA + sport + COMMA + city + COMMA + username + "' )";
           String sqlQuery = String.format(query);
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
    public boolean updatePasswordAfterReset(IUser user) {
        String email = user.getEmail();
        String password = user.getPassword();

        String query = QueryConstants.USER_SET_PASSWORD + password + WHERE_CLAUSE + email + SINGLE_QUOTE;
        String sqlQuery = String.format(query);
        boolean resultSet = false;
        try {
            resultSet = PlayupDBConnection.getInstance().updateData(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
