//@Author Mugdha Agharkar

package com.playup.dao.user;

public abstract class UserProfileAbstractFactoryDao {

    public abstract IOneTimePasswordDao oneTimePasswordDao();

    public abstract IUserDao userDao();
}
