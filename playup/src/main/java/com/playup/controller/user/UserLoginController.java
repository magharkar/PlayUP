package com.playup.controller.user;

import com.playup.constants.ApplicationConstants;
import com.playup.model.user.User;
import com.playup.model.user.UserFactory;
import com.playup.model.user.UserObjectFactory;
import com.playup.service.user.IUserLoginService;
import com.playup.service.user.UserProfileServiceFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Mugdha Anil Agharkar
 */

@Controller
public class UserLoginController {
    IUserLoginService userLoginService;
    public UserLoginController() {
        this.userLoginService = UserProfileServiceFactory.instance().userLoginService();
    }

    @GetMapping(ApplicationConstants.LOGIN_URL)
    public String getLogin(Model model) {
        model.addAttribute(ApplicationConstants.USER_OBJECT, UserFactory.userObject(new UserObjectFactory()));
        return ApplicationConstants.LOGIN_HTML;
    }

    @PostMapping(ApplicationConstants.LOGIN_URL)
    public String logUser(@ModelAttribute User user, Model model) {
        boolean success = userLoginService.verifyUser(user, model);

        if (success) {
            String userRole = userLoginService.getUserRoleByEmail(user, model);
            if(userRole.equals(ApplicationConstants.ADMIN_ROLE)) {
                return ApplicationConstants.ADMIN_LANDING_HTML;
            }
            return ApplicationConstants.REDIRECT_VENUE_HTML;
        } else {
            model.addAttribute(user);
            model.addAttribute(ApplicationConstants.FAILED_RESULT, ApplicationConstants.UNSUCCESSFUL_LOGIN);
            return ApplicationConstants.LOGIN_HTML;
        }
    }

}
