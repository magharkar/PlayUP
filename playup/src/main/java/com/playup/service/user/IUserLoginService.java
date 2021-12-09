/**
 * @author Mugdha Anil Agharkar
 */
package com.playup.service.user;

import com.playup.model.user.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.ui.Model;

public interface IUserLoginService {
    boolean verifyUser(User user, Model model);

    String getUserRoleByEmail(User user, Model model);
}
