package com.playup.model.user;

/**
 * @author Mugdha Anil Agharkar
 */
public class UserFactory {

    public static IUser userObject(UserAbstractFactory userAbstractFactory) {
        return userAbstractFactory.userObject();
    }
}
