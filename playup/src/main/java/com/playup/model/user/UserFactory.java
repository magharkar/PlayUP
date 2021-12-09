//@Author Mugdha Agharkar

package com.playup.model.user;

public class UserFactory {

    public static IUser userObject(UserAbstractFactory userAbstractFactory) {
        return userAbstractFactory.userObject();
    }
}
