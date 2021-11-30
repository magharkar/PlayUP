package com.playup.dao;

import com.playup.database.PlayupDBConnection;
import com.playup.model.IUser;
import com.playup.model.OneTimePassword;
import com.playup.model.UserFactory;
import com.playup.model.UserObjectFactory;
import com.playup.service.IEmailSender;
import com.playup.service.UserProfileServiceFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OneTimePasswordDao implements IOneTimePasswordDao {
    @Override
    public void setOneTimePassword(OneTimePassword oneTimePassword) throws SQLException {
        String email = oneTimePassword.getEmailId();
        String otp = oneTimePassword.getOneTimePassword();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(oneTimePassword.getOneTimePasswordDate());

        String query = "Insert into user_otp_mapping (otp, email, date) values " +
                "('" + otp + "'," + "'" + email + "'," + "'" + date + "' )";
        String sqlQuery = String.format(query);
        System.out.println(sqlQuery);
        boolean resultSet = PlayupDBConnection.getInstance().updateData(sqlQuery);
    }

    @Override
    public ArrayList<OneTimePassword> getOneTimePasswordByEmail(String email) throws SQLException, ParseException {
        ArrayList<OneTimePassword> oneTimePasswordArrayList = new ArrayList<>();
        String query = "Select * from user_otp_mapping where email=" + "'" + email + "'";
        String sqlQuery = String.format(query);
        //String sqlQuery = String.format("select * from CSCI5308_1_DEVINT.User where city = %s;",userName);
        ResultSet resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);
        System.out.println(sqlQuery);


        while (resultSet.next()) {
            OneTimePassword oneTimePassword = new OneTimePassword();

            oneTimePassword.setEmailId(resultSet.getString("email"));
            oneTimePassword.setUserName(resultSet.getString("username"));
            oneTimePassword.setOneTimePassword(resultSet.getString("otp"));
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultSet.getString("date"));
            oneTimePassword.setOneTimePasswordDate(date);
            oneTimePasswordArrayList.add(oneTimePassword);
        }
        return oneTimePasswordArrayList;
    }
}
