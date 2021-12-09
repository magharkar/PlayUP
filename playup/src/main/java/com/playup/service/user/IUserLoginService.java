/**
 * @author Mugdha Anil Agharkar
 */
package com.playup.service.user;

import com.playup.model.user.User;
import org.springframework.ui.Model;

public interface IUserLoginService {
    boolean verifyUser(User user, Model model);
}
