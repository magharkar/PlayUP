//@Author Mugdha Agharkar

package com.playup.service.user;

import com.playup.service.EmailSenderService;
import com.playup.service.IEmailSender;

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
