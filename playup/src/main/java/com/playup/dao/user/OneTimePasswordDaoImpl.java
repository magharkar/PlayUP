package com.playup.dao.user;

import com.playup.constants.ApplicationConstants;
import com.playup.constants.QueryConstants;
import com.playup.database.PlayupDBConnection;
import com.playup.model.user.OneTimePassword;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Mugdha Anil Agharkar
 */

public class OneTimePasswordDaoImpl implements IOneTimePasswordDao {
    private final String COMMA = "','";
    private final String SINGLE_QUOTE = "'";
    @Override
    public boolean setOneTimePassword(OneTimePassword oneTimePassword) {
        try {
            String email = oneTimePassword.getEmailId();
            String otp = oneTimePassword.getOneTimePassword();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = dateFormat.format(oneTimePassword.getOneTimePasswordDate());

            String query = QueryConstants.INSERT_USER_OTP + "('" + otp + COMMA + email + COMMA + date + "' )";
            String sqlQuery = String.format(query);
            boolean resultSet = PlayupDBConnection.getInstance().updateData(sqlQuery);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public ArrayList<OneTimePassword> getOneTimePasswordByEmail(String email) {
        try{
            ArrayList<OneTimePassword> oneTimePasswordArrayList = new ArrayList<>();
            String query = QueryConstants.SELECT_USER_OTP + email + SINGLE_QUOTE;
            String sqlQuery = String.format(query);
            ResultSet resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);

            while (resultSet.next()) {
                OneTimePassword oneTimePassword = new OneTimePassword();

                oneTimePassword.setEmailId(resultSet.getString(ApplicationConstants.EMAIL));
                oneTimePassword.setUserName(resultSet.getString(ApplicationConstants.USERNAME));
                oneTimePassword.setOneTimePassword(resultSet.getString(ApplicationConstants.OTP_HTML));
                Date date = null;
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultSet.getString("date"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                oneTimePassword.setOneTimePasswordDate(date);
                oneTimePasswordArrayList.add(oneTimePassword);
            }
            return oneTimePasswordArrayList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
