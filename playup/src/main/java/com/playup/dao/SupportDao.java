package com.playup.dao;


import com.playup.model.SupportModel;

public class SupportDao implements ISupportDao{


    @Override
    public boolean checkWhetherTicketNumberExists(int ticketNumber) {

        return false;
    }

    @Override
    public boolean generateSupportRequest(SupportModel supportModel) {

        return true;
    }

    @Override
    public void sendConfirmation() {

    }
}
