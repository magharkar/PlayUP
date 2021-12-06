/**
 * @author Shiv Gaurang Desai
 */
package com.playup.tests;

import static org.junit.jupiter.api.Assertions.*;
import com.playup.constants.ApplicationConstants;
import com.playup.service.support.SupportTicketGeneratorServiceImpl;
import org.junit.jupiter.api.Test;

public class TicketGeneratorServiceTest {

    //Not Null test case
    @Test
    void ticketGeneratorServiceNotNullTest() throws ClassNotFoundException {
        Class<?> classFinder = Class.forName("com.playup.service.support.SupportTicketGeneratorServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classFinder);
    }

    //Testing for valid Ticket Number
    @Test
    void ticketNumberValidTest() {
        SupportTicketGeneratorServiceImpl ticketGeneratorService = new SupportTicketGeneratorServiceImpl();
        int number = ticketGeneratorService.generateTicketNumber(ApplicationConstants.MINIMUM_SUPPORT_TICKET_NUMBER,ApplicationConstants.MAXIMUM_SUPPORT_TICKET_NUMBER);
        assertTrue(number>=1000&&number<=10000);
    }

    //Testing for invalid Ticket Number
    @Test
    void ticketNumberNotValidTest() {
        SupportTicketGeneratorServiceImpl ticketGeneratorService = new SupportTicketGeneratorServiceImpl();
        int number = ticketGeneratorService.generateTicketNumber(ApplicationConstants.MINIMUM_SUPPORT_TICKET_NUMBER,ApplicationConstants.MAXIMUM_SUPPORT_TICKET_NUMBER);
        assertFalse(number<1000||number>10000);
    }
}
