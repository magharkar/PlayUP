/**
 * @author Mugdha Anil Agharkar
 */
package com.playup.dao.user;

import com.playup.database.PlayupDBConnection;
import com.playup.model.user.OneTimePassword;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OneTimePasswordDaoImpl implements IOneTimePasswordDao {
    @Override
    public boolean setOneTimePassword(OneTimePassword oneTimePassword) {
        try {
            String email = oneTimePassword.getEmailId();
            String otp = oneTimePassword.getOneTimePassword();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = dateFormat.format(oneTimePassword.getOneTimePasswordDate());

            String query = "Insert into user_otp_mapping (otp, email, date) values " +
                    "('" + otp + "'," + "'" + email + "'," + "'" + date + "' )";
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
            String query = "Select * from user_otp_mapping where email=" + "'" + email + "'";
            String sqlQuery = String.format(query);
            ResultSet resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);

            while (resultSet.next()) {
                OneTimePassword oneTimePassword = new OneTimePassword();

                oneTimePassword.setEmailId(resultSet.getString("email"));
                oneTimePassword.setUserName(resultSet.getString("username"));
                oneTimePassword.setOneTimePassword(resultSet.getString("otp"));
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
