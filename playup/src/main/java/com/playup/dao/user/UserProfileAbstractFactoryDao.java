package com.playup.dao.user;

/**
 * @author Mugdha Anil Agharkar
 */

public abstract class UserProfileAbstractFactoryDao {
    public abstract IOneTimePasswordDao oneTimePasswordDao();

    public abstract IUserDao userDao();
}
