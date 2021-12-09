/**
 * @author Mugdha Anil Agharkar
 */
package com.playup.service.user;

public abstract class UserProfileServiceAbstractFactory {
    public abstract IUserLoginService userLoginService();

    public abstract IOneTimePasswordService oneTimePasswordService();

    public abstract IUserRegistrationService userRegistrationService();
}
