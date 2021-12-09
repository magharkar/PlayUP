package com.playup.model.user;

/**
 * @author Mugdha Anil Agharkar
 */

public class UserObjectFactory extends UserAbstractFactory {
    @Override
    public IUser userObject() {
        return new User();
    }
}
