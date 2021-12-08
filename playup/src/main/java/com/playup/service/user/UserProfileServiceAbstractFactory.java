//@Author Mugdha Agharkar

package com.playup.service.user;

import com.playup.service.email.IEmailSenderService;

public abstract class UserProfileServiceAbstractFactory {

    public abstract IUserLoginService userLoginService();

    public abstract IEmailSenderService emailSenderService();

    public abstract IOneTimePasswordService oneTimePasswordService();

    public abstract IUserRegistrationService userRegistrationService();
}
