package com.playup.service.user;

/**
 * @author Mugdha Anil Agharkar
 */
public abstract class UserProfileServiceAbstractFactory {
    public abstract IUserLoginService userLoginService();

    public abstract IOneTimePasswordService oneTimePasswordService();

    public abstract IUserRegistrationService userRegistrationService();
}
