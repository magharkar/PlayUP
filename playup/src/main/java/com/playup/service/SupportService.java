package com.playup.service;
import com.playup.dao.SupportDao;
import com.playup.model.SupportModel;
import org.springframework.stereotype.Service;

import java.lang.*;
import java.sql.SQLException;

@Service
public class SupportService implements  ISupport{


    @Override
    public int generateTicketNumber() {
     int minimumTicketNumber = 1000;
     int maximumTicketNumber = 10000;
     int ticketNumber = (int)(Math.random()*(maximumTicketNumber-minimumTicketNumber+1)+minimumTicketNumber);
     try {
         boolean isNumberExits = SupportDao.getInstance().checkWhetherTicketNumberExists(ticketNumber);
         while(isNumberExits) {
             ticketNumber = (int)(Math.random()*(maximumTicketNumber-minimumTicketNumber+1)+minimumTicketNumber);
             isNumberExits = SupportDao.getInstance().checkWhetherTicketNumberExists(ticketNumber);
         }
     }catch(SQLException s) {
         System.out.println(s);
         return -1;
     }
     return ticketNumber;
    }
    
    @Override
    public boolean generateSupportRequest(SupportModel supportModel)  {
        boolean isSupportRequestCreated = false;
        try{
            isSupportRequestCreated = SupportDao.getInstance().generateSupportRequest(supportModel);
        } catch (Exception e) {
            System.out.println(e);
        }
        return isSupportRequestCreated;
    }

}
