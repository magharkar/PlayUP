package com.playup.service;

import com.playup.model.SupportModel;

public interface ISupport {

    int generateTicketNumber();
    void generateSupportRequest(SupportModel supportModel);
}
