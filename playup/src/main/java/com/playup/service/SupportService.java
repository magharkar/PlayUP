package com.playup.service;
import com.playup.dao.SupportDao;
import com.playup.model.SupportModel;
import org.springframework.stereotype.Service;

import java.lang.*;

@Service
public class SupportService implements  ISupport{

   private SupportDao supportDao;

    @Override
    public int generateTicketNumber() {
     int minimumTicketNumber = 1000;
     int maximumTicketNumber = 10000;
      supportDao = new SupportDao();
     int ticketNumber = (int)(Math.random()*(maximumTicketNumber-minimumTicketNumber+1)+minimumTicketNumber);
     boolean isNumberExits = supportDao.checkWhetherTicketNumberExists(ticketNumber);
     while(!isNumberExits) {
         ticketNumber = (int)(Math.random()*(maximumTicketNumber-minimumTicketNumber+1)+minimumTicketNumber);
         isNumberExits = supportDao.checkWhetherTicketNumberExists(ticketNumber);
     }
     return ticketNumber;
    }

    @Override
    public void generateSupportRequest(SupportModel supportModel) {
        int ticketNumber = generateTicketNumber();
        supportModel.setTicketNumber(ticketNumber);
        supportDao = new SupportDao();
        supportDao.generateSupportRequest(supportModel);
    }

}
