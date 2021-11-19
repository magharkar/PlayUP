package com.playup.dao;


import com.playup.controller.PlayupDBConnection;
import com.playup.model.SupportModel;

public class SupportDao implements ISupportDao{


    @Override
    public boolean checkWhetherTicketNumberExists(int ticketNumber) {

        return true;
    }

    @Override
    public boolean generateSupportRequest(SupportModel supportModel) {

        return true;
    }

    @Override
    public void sendConfirmation() {

    }
}
