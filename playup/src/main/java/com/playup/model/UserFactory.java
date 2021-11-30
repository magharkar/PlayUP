package com.playup.model;

import com.playup.model.IUser;
import com.playup.model.UserAbstractFactory;

public class UserFactory {
    public static IUser userObject(UserAbstractFactory userAbstractFactory) {
        return userAbstractFactory.userObject();
    }
}
