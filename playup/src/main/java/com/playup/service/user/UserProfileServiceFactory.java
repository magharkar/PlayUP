//@Author Mugdha Agharkar

package com.playup.service.user;

import com.playup.service.email.EmailSenderServiceImpl;
import com.playup.service.email.IEmailSenderService;

public class UserProfileServiceFactory extends UserProfileServiceAbstractFactory {
    private static UserProfileServiceFactory instance = null;
    private IUserLoginService userLoginService;
    private IEmailSenderService emailSenderService;
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
            userLoginService = new UserLoginServiceImpl();
        }
        return userLoginService;
    }

    @Override
    public IEmailSenderService emailSenderService() {
        if(emailSenderService == null) {
            emailSenderService = new EmailSenderServiceImpl();
        }
        return emailSenderService;
    }

    @Override
    public IOneTimePasswordService oneTimePasswordService() {
        if(oneTimePasswordService == null) {
            oneTimePasswordService = new OneTimePasswordServiceImpl();
        }
        return oneTimePasswordService;
    }

    @Override
    public IUserRegistrationService userRegistrationService() {
        if(userRegistrationService == null) {
            userRegistrationService = new UserRegistrationServiceImpl();
        }
        return userRegistrationService;
    }
}
