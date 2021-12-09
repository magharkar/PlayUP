/**
 * @author Mugdha Anil Agharkar
 */
package com.playup.controller.user;

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
import java.sql.SQLException;

@Controller
public class UserLoginController {
    IUserLoginService userLoginService;
    public UserLoginController() {
        this.userLoginService = UserProfileServiceFactory.instance().userLoginService();
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("user", UserFactory.userObject(new UserObjectFactory()));
        return "login";
    }

    @PostMapping("/login")
    public String logUser(@ModelAttribute User user, Model model) throws SQLException {
        boolean success = userLoginService.verifyUser(user, model);


        if (success) {
            String userRole = userLoginService.getUserRoleByEmail(user, model);
            System.out.println("userrole" + userRole);
            if(userRole.equals("admin")) {
                return "admin_landing_page";
            }
            return "redirect:/venues";
        } else {
            model.addAttribute(user);
            model.addAttribute("failure", "Login unsuccessful");
            return "login";
        }
    }

}
