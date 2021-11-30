package com.playup.dao;

public abstract class UserProfileDaoAbstractFactory {
    public abstract IOneTimePasswordDao oneTimePasswordDao();
    public abstract IUserDao userDao();
}
