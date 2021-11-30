package com.playup.dao;

public class UserProfileDaoFactory extends UserProfileDaoAbstractFactory {

    private static UserProfileDaoFactory instance = null;
    private IOneTimePasswordDao oneTimePasswordDao;
    private IUserDao userDao;

    private UserProfileDaoFactory () {

    }

    public static UserProfileDaoFactory instance() {
        if (null == instance) {
            instance = new UserProfileDaoFactory();
        }
        return instance;
    }

    @Override
    public IOneTimePasswordDao oneTimePasswordDao() {
        if(oneTimePasswordDao == null) {
            oneTimePasswordDao = new OneTimePasswordDao();
        }
        return oneTimePasswordDao;
    }

    @Override
    public IUserDao userDao() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }
}
