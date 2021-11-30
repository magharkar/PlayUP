package com.playup.dao;

public abstract class UserProfileAbstractFactoryDao {
    public abstract IOneTimePasswordDao oneTimePasswordDao();
    public abstract IUserDao userDao();
}
