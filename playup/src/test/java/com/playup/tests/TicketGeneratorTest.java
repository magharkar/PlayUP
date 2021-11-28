/**
 * @author Shiv Gaurang Desai
 */

package com.playup.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

import com.playup.constants.ApplicationConstants;
import com.playup.dao.SearchVenue;
import com.playup.dao.Venue;
import com.playup.database.DataBaseUtilities;
import com.playup.model.SupportModel;
import com.playup.service.TicketGeneratorService;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketGeneratorTest {

    //Not Null test case
    @Test
    void ticketGeneratorServiceNotNullTest() throws ClassNotFoundException {
        Class<?> classFinder = Class.forName("com.playup.service.TicketGeneratorService", false, getClass().getClassLoader());
        assertNotNull(classFinder);
    }

    //Testing for valid Ticket Number
    @Test
    void ticketNumberValidTest() {
        TicketGeneratorService ticketGeneratorService = new TicketGeneratorService();
        int number = ticketGeneratorService.generateTicketNumber(ApplicationConstants.minimumSupportTicketNumber,ApplicationConstants.maximumSupportTicketNumber);
            assertTrue(number>=1000&&number<=10000);
    }

    //Testing for invalid Ticket Number
    @Test
    void ticketNumberNotValidTest() {
        TicketGeneratorService ticketGeneratorService = new TicketGeneratorService();
        int number = ticketGeneratorService.generateTicketNumber(ApplicationConstants.minimumSupportTicketNumber,ApplicationConstants.maximumSupportTicketNumber);
        assertFalse(number<1000||number>10000);
    }
}
