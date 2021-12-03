package com.playup.model.support;

import com.playup.model.IUser;
import com.playup.model.User;

public class SupportObjectFactory extends SupportAbstractFactory {
    @Override
    public IUser userObject() {
        return new User();
    }
}
