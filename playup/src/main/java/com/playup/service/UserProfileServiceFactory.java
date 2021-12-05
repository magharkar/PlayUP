package com.playup.service;

import com.playup.service.email.EmailSenderService;
import com.playup.service.email.IEmailSender;

public class UserProfileServiceFactory extends UserProfileServiceAbstractFactory {
    private static UserProfileServiceFactory instance = null;
    private IUserLoginService userLoginService;
    private IEmailSender emailSenderService;
    private IOneTimePasswordService oneTimePasswordService;
    private IUserRegistrationService userRegistrationService;

    private UserProfileServiceFactory() {

    }

    public static UserProfileServiceFactory instance() {
        if (instance == null) {
            instance = new UserProfileServiceFactory();
        }
        return instance;
    }

    @Override
    public IUserLoginService userLoginService() {
        if(userLoginService == null) {
            userLoginService = new UserLoginService();
        }
        return userLoginService;
    }

    @Override
    public IEmailSender emailSenderService() {
        if(emailSenderService == null) {
            emailSenderService = new EmailSenderService();
        }
        return emailSenderService;
    }

    @Override
    public IOneTimePasswordService oneTimePasswordService() {
        if(oneTimePasswordService == null) {
            oneTimePasswordService = new OneTimePasswordService();
        }
        return oneTimePasswordService;
    }

    @Override
    public IUserRegistrationService userRegistrationService() {
        if(userRegistrationService == null) {
            userRegistrationService = new UserRegistrationService();
        }
        return userRegistrationService;
    }
}
