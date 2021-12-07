//@Author Mugdha Agharkar

package com.playup.service.user;

import com.playup.model.user.User;
import org.springframework.ui.Model;

import java.sql.SQLException;

public interface IUserLoginService {

    boolean verifyUser(User user, Model model) throws SQLException;
}
