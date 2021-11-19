package com.playup.dao;

import com.playup.model.SupportModel;

public interface ISupportDao {

    public boolean checkWhetherTicketNumberExists(int ticketNumber);

    public boolean generateSupportRequest(SupportModel supportModel);

    public void sendConfirmation();
}
