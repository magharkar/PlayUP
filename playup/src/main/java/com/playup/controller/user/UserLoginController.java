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
       System.out.println("Reaching here");
        model.addAttribute("user", UserFactory.userObject(new UserObjectFactory()));
        return "login";
    }

    @PostMapping("/login")
    public String logUser(@ModelAttribute User user, Model model) throws SQLException {
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        boolean success = userLoginService.verifyUser(user, model);
        if (success) {
            model.addAttribute("success", "Login successful");
            return "support";
        } else {
            model.addAttribute("failure", "Login unsuccessful");
            return "login";
        }
    }

}
