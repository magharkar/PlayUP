package com.playup.dao.user;

import com.playup.model.user.OneTimePassword;

import java.util.ArrayList;

/**
 * @author Mugdha Anil Agharkar
 */

public interface IOneTimePasswordDao {
    boolean setOneTimePassword(OneTimePassword oneTimePassword);

    ArrayList<OneTimePassword> getOneTimePasswordByEmail(String email);
}
