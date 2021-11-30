package com.playup.service;

import com.playup.model.User;
import org.springframework.ui.Model;

import java.sql.SQLException;

public interface IUserLoginService {

    public boolean verifyUser(User user, Model model) throws SQLException;
}
