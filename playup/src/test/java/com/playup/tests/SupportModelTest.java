/**
 * @author Shiv Gaurang Desai
 */
package com.playup.tests;

import com.playup.model.support.SupportModel;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SupportModelTest {

    //Testing Not Null case for Support Model
    @Test
    void supportModelClassNotNullTest( ) throws ClassNotFoundException {
        Class<?> classFinder = Class.forName("com.playup.model.support.SupportModel", false, getClass().getClassLoader());
        assertNotNull(classFinder);
    }

    //Testing getter and constructor for SupportModel Class
    @Test
    void venueGetterTest() {
        SupportModel supportModel = new SupportModel(1001,"Shiv", "shivdesai612@gmail.com", "dalplex", "Not Booking Venue");
        assertEquals(1001,supportModel.getTicketNumber());
        assertEquals("Shiv",supportModel.getName());
        assertEquals("shivdesai612@gmail.com",supportModel.getEmail());
        assertEquals("dalplex",supportModel.getVenue());
        assertEquals("Not Booking Venue",supportModel.getDescription());
    }

    //Testing setter for SupportModel Class
    @Test
    void venueSetterTest() {
        SupportModel supportModel = new SupportModel();
        supportModel.setTicketNumber(1002);
        assertEquals(1002,supportModel.getTicketNumber());
        supportModel.setName("Shiv Desai");
        assertEquals("Shiv Desai",supportModel.getName());
        supportModel.setVenue("Dalplex");
        assertEquals("Dalplex",supportModel.getVenue());
        supportModel.setDescription("Not able to book Venue");
        assertEquals("Not able to book Venue",supportModel.getDescription());
    }

}
