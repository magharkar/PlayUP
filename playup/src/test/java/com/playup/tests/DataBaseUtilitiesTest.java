package com.playup.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import com.playup.dao.Venue;
import com.playup.database.DataBaseUtilities;
import com.playup.database.PlayupDBConnection;

class DataBaseUtilitiesTest {

	@Test
	void dataBaseUtilitiesNotNullTest() throws ClassNotFoundException {
		Class<?> classFinder = Class.forName("com.playup.database.DataBaseUtilities", false, getClass().getClassLoader());
		assertNotNull(classFinder);
	}
	
	@Test
	void getInstanceTest()  {
		DataBaseUtilities dbu1 = DataBaseUtilities.getInstance();
		assertEquals(DataBaseUtilities.getInstance(), dbu1);
	}

	@Test
	void getVenuesFromDbTest( ) throws SQLException {
		PlayupDBConnection dbCon = Mockito.mock(PlayupDBConnection.class);
		Venue expectedVenue = new Venue("mockVenueId", "mockVenueName", "mockVenueCity", "mockAvailableSlots", "mockTotalSlots", "mockFromTime", "mockToTime", "mockContactNo",
				"mockLatitude", "mockLongitude", "mockSlotPrice", "mockAvgRatings", "mockCategoryId");
		try (MockedStatic<PlayupDBConnection> mocked = mockStatic(PlayupDBConnection.class)) {
			mocked.when(PlayupDBConnection::getInstance).thenReturn(dbCon);
			ResultSet resultSetMock = Mockito.mock(ResultSet.class);
			Mockito.when(dbCon.readData("Select * from Venues;")).thenReturn(resultSetMock);
			Mockito.when(resultSetMock.getString("venue_id")).thenReturn("mockVenueId");
			Mockito.when(resultSetMock.getString("name")).thenReturn("mockVenueName");
			Mockito.when(resultSetMock.getString("city")).thenReturn("mockVenueCity");
			Mockito.when(resultSetMock.getString("available_slots")).thenReturn("mockAvailableSlots");
			Mockito.when(resultSetMock.getString("total_slots")).thenReturn("mockTotalSlots");
			Mockito.when(resultSetMock.getString("from_time")).thenReturn("mockFromTime");
			Mockito.when(resultSetMock.getString("to_time")).thenReturn("mockToTime");
			Mockito.when(resultSetMock.getString("contact_info")).thenReturn("mockContactNo");
			Mockito.when(resultSetMock.getString("latitude")).thenReturn("mockLatitude");
			Mockito.when(resultSetMock.getString("longitude")).thenReturn("mockLongitude");
			Mockito.when(resultSetMock.getString("slot_price")).thenReturn("mockSlotPrice");
			Mockito.when(resultSetMock.getString("avg_ratings")).thenReturn("mockAvgRatings");
			Mockito.when(resultSetMock.getString("category_id")).thenReturn("mockCategoryId");
			Mockito.when(resultSetMock.next()).thenReturn(true).thenReturn(false);
			
			List<Venue> actualOutput = DataBaseUtilities.getInstance().getVenuesFromDB();
			for(Venue actualVenue: actualOutput) {
				assertEquals(expectedVenue.getVenueID(),actualVenue.getVenueID());
				assertEquals(expectedVenue.getVenueName(),actualVenue.getVenueName());
				assertEquals(expectedVenue.getVenueCity(),actualVenue.getVenueCity());
				assertEquals(expectedVenue.getAvailableSlots(),actualVenue.getAvailableSlots());
				assertEquals(expectedVenue.getTotalSlots(),actualVenue.getTotalSlots());
				assertEquals(expectedVenue.getFromTime(),actualVenue.getFromTime());
				assertEquals(expectedVenue.getToTime(),actualVenue.getToTime());
				assertEquals(expectedVenue.getContactInfo(),actualVenue.getContactInfo());
				assertEquals(expectedVenue.getLattitude(),actualVenue.getLattitude());
				assertEquals(expectedVenue.getLongitude(),actualVenue.getLongitude());
				assertEquals(expectedVenue.getSlotPrice(),actualVenue.getSlotPrice());
				assertEquals(expectedVenue.getAverageRating(),actualVenue.getAverageRating());
				assertEquals(expectedVenue.getCategoryID(),actualVenue.getCategoryID());
			}
		}
	}
}
