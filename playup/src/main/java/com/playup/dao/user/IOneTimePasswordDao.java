package com.playup.dao.user;

import com.playup.model.user.OneTimePassword;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public interface IOneTimePasswordDao {

    public void setOneTimePassword(OneTimePassword oneTimePassword) throws SQLException;

    public ArrayList<OneTimePassword> getOneTimePasswordByEmail(String email) throws SQLException, ParseException;
}
