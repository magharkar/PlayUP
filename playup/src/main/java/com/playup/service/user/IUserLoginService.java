package com.playup.service.user;

import com.playup.model.user.User;
import org.springframework.ui.Model;

/**
 * @author Mugdha Anil Agharkar
 */
public interface IUserLoginService {
    boolean verifyUser(User user, Model model);

    String getUserRoleByEmail(User user, Model model);
}
