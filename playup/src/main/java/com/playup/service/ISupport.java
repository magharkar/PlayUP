package com.playup.service;

import com.playup.model.SupportModel;

import java.sql.SQLException;

public interface ISupport {

    int generateTicketNumber() throws SQLException;
    boolean generateSupportRequest(SupportModel supportModel) throws SQLException;
}
