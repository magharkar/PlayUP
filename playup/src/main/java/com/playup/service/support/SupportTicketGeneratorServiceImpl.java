package com.playup.service.support;

import com.playup.dao.support.SupportDaoImpl;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

/**
 * @author Shiv Gaurang Desai
 */
@Service
public class SupportTicketGeneratorServiceImpl implements ISupportTicketGeneratorService {
    @Override
    public int generateTicketNumber(int minimumTicketNumber, int maximumTicketNumber) {
        int ticketNumber = (int)(Math.random()*(maximumTicketNumber-minimumTicketNumber+1)+minimumTicketNumber);
        try {
            boolean isNumberExits = SupportDaoImpl.getInstance().checkWhetherTicketNumberExists(ticketNumber);
            while(isNumberExits) {
                ticketNumber = (int)(Math.random()*(maximumTicketNumber-minimumTicketNumber+1)+minimumTicketNumber);
                isNumberExits = SupportDaoImpl.getInstance().checkWhetherTicketNumberExists(ticketNumber);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return ticketNumber;
    }
}
