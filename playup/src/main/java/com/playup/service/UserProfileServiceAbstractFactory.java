package com.playup.service;

public abstract class UserProfileServiceAbstractFactory {
    public abstract IUserLoginService userLoginService();

    public abstract IEmailSender emailSenderService();

    public abstract IOneTimePasswordService oneTimePasswordService();

    public abstract IUserRegistrationService userRegistrationService();
}
