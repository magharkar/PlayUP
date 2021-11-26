package com.playup.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.playup.dao.Venue;

class VenueClassTests {
	
	//Not Null test case
	@Test
	void venueClassNotNullTest( ) throws ClassNotFoundException {
		Class<?> classFinder = Class.forName("com.playup.dao.Venue", false, getClass().getClassLoader());
		assertNotNull(classFinder);
	}
	//To test the getters & constructor in the Venue class
	@Test
	void venueGetterTest() {
		Venue venue = new Venue("123", "Scotia stadium", "Halifax", "5", "6", "8:00:00", "3:00:00", "987-876-123", "76648.477", "12453.31", "$30", "3.5", "0");
		assertEquals("123",venue.getVenueID());
		assertEquals("Scotia stadium",venue.getVenueName());
		assertEquals("Halifax",venue.getVenueCity());
		assertEquals("5",venue.getAvailableSlots());
		assertEquals("6",venue.getTotalSlots());
		assertEquals("8:00:00",venue.getFromTime());
		assertEquals("3:00:00",venue.getToTime());
		assertEquals("987-876-123",venue.getContactInfo());
		assertEquals("76648.477",venue.getLattitude());
		assertEquals("12453.31",venue.getLongitude());
		assertEquals("$30",venue.getSlotPrice());
		assertEquals("3.5",venue.getAverageRating());
		assertEquals("0",venue.getCategoryID());
	}

	//To test the setters in the Venue class
	@Test
	void venueSetterTest() {
		Venue venue = new Venue("123", "Scotia stadium", "Halifax", "5", "6", "8:00:00", "3:00:00", "987-876-123", "76648.477", "12453.31", "$30", "3.5", "0");
		venue.setVenueID("243");
		assertEquals("243",venue.getVenueID());
		venue.setVenueName("Toronto Common");
		assertEquals("Toronto Common",venue.getVenueName());
		venue.setVenueCity("Toronto");
		assertEquals("Toronto",venue.getVenueCity());
		venue.setAvailableSlots("8");
		assertEquals("8",venue.getAvailableSlots());
		venue.setTotalSlots("58");
		assertEquals("58",venue.getTotalSlots());
		venue.setFromTime("9:00:00");
		assertEquals("9:00:00",venue.getFromTime());
		venue.setToTime("6:00:00");
		assertEquals("6:00:00",venue.getToTime());
		venue.setContactInfo("782-641-1066");
		assertEquals("782-641-1066",venue.getContactInfo());
		venue.setLattitude("543.456");
		assertEquals("543.456",venue.getLattitude());
		venue.setLongitude("786.443");
		assertEquals("786.443",venue.getLongitude());
		venue.setSlotPrice("$87");
		assertEquals("$87",venue.getSlotPrice());
		venue.setAverageRating("4");
		assertEquals("4",venue.getAverageRating());
		venue.setCategoryID("2");
		assertEquals("2",venue.getCategoryID());
	}
}
