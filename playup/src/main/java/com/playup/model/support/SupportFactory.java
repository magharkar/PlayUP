package com.playup.model.support;

import com.playup.model.IUser;

public class SupportFactory {
    public static IUser userObject(SupportAbstractFactory userAbstractFactory) {
        return userAbstractFactory.userObject();
    }
}
