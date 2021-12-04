//@Author Mugdha Agharkar

package com.playup.dao.user;

import com.playup.model.user.OneTimePassword;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public interface IOneTimePasswordDao {

    void setOneTimePassword(OneTimePassword oneTimePassword) throws SQLException;

    ArrayList<OneTimePassword> getOneTimePasswordByEmail(String email) throws SQLException, ParseException;
}
