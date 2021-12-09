/**
 * @author Mugdha Anil Agharkar
 */
package com.playup.model.user;

public class UserObjectFactory extends UserAbstractFactory {
    @Override
    public IUser userObject() {
        return new User();
    }
}
