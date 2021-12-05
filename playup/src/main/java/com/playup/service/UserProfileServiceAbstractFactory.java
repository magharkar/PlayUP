package com.playup.service;

import com.playup.service.email.IEmailSender;

public abstract class UserProfileServiceAbstractFactory {
    public abstract IUserLoginService userLoginService();

    public abstract IEmailSender emailSenderService();

    public abstract IOneTimePasswordService oneTimePasswordService();

    public abstract IUserRegistrationService userRegistrationService();
}
