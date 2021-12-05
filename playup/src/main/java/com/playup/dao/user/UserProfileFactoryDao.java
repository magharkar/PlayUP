//@Author Mugdha Agharkar

package com.playup.dao.user;

public class UserProfileFactoryDao extends UserProfileAbstractFactoryDao {

    private static UserProfileFactoryDao instance = null;
    private IOneTimePasswordDao oneTimePasswordDao;
    private IUserDao userDao;

    private UserProfileFactoryDao() {

    }

    public static UserProfileFactoryDao instance() {
        if (null == instance) {
            instance = new UserProfileFactoryDao();
        }
        return instance;
    }

    @Override
    public IOneTimePasswordDao oneTimePasswordDao() {
        if(oneTimePasswordDao == null) {
            oneTimePasswordDao = new OneTimePasswordDaoImpl();
        }
        return oneTimePasswordDao;
    }

    @Override
    public IUserDao userDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }
}
