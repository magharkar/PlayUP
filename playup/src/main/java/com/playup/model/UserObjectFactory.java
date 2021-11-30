package com.playup.model;

import com.playup.model.IUser;
import com.playup.model.User;
import com.playup.model.UserAbstractFactory;

public class UserObjectFactory extends UserAbstractFactory {
    @Override
    public IUser userObject() {
        return new User();
    }
}
