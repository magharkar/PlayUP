/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.support;

import com.playup.dao.support.SupportDaoImpl;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

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
        }catch(SQLException s) {
            System.out.println(s);
        }
        return ticketNumber;
    }
}
