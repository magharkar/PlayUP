package com.playup.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mockStatic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import com.playup.dao.search.SearchVenueDao;
import com.playup.database.PlayupDBConnection;
import com.playup.model.search.SearchVenue;

class SearchVenueDaoTests {

	@Test
	void searchVenueNotNullTest() throws ClassNotFoundException {
		Class<?> classFinder = Class.forName("com.playup.dao.search.SearchVenueDao", false, getClass().getClassLoader());
		assertNotNull(classFinder);
	}
 
	@Test
	void searchTests() throws SQLException {
		ArrayList<Object> expectedOutput = new ArrayList<Object>();
		SearchVenueDao sv = new SearchVenueDao();
		List<SearchVenue> venueList = new ArrayList<SearchVenue>();
		SearchVenue venue1 = new SearchVenue("2000001", "DalPlex", "Halifax", "5", "10", "8:00:00", "20:00:00", "902-494-3372",
				"44.6345", "63.5926", "$50", "4", "0");
		venueList.add(venue1);
		PlayupDBConnection dbCon = Mockito.mock(PlayupDBConnection.class);
		try (MockedStatic<PlayupDBConnection> mocked = mockStatic(PlayupDBConnection.class)) {
			mocked.when(PlayupDBConnection::getInstance).thenReturn(dbCon);
			ResultSet resultSetMock = Mockito.mock(ResultSet.class);
			Mockito.when(dbCon.readData("Select * from Venues;")).thenReturn(resultSetMock);
			Mockito.when(resultSetMock.getString("venue_id")).thenReturn("2000001");
			Mockito.when(resultSetMock.getString("name")).thenReturn("DalPlex");
			Mockito.when(resultSetMock.getString("city")).thenReturn("Halifax");
			Mockito.when(resultSetMock.getString("available_slots")).thenReturn("5");
			Mockito.when(resultSetMock.getString("total_slots")).thenReturn("10");
			Mockito.when(resultSetMock.getString("from_time")).thenReturn("8:00:00"); 
			Mockito.when(resultSetMock.getString("to_time")).thenReturn("20:00:00");
			Mockito.when(resultSetMock.getString("contact_info")).thenReturn("902-494-3372");
			Mockito.when(resultSetMock.getString("latitude")).thenReturn("44.6345");
			Mockito.when(resultSetMock.getString("longitude")).thenReturn("63.5926");
			Mockito.when(resultSetMock.getString("slot_price")).thenReturn("$50");
			Mockito.when(resultSetMock.getString("avg_ratings")).thenReturn("4");
			Mockito.when(resultSetMock.getString("category_id")).thenReturn("0");
			Mockito.when(resultSetMock.next()).thenReturn(true).thenReturn(false);
			ArrayList<Object> actualOutput = sv.search("Halif");
			expectedOutput.add(venue1);
			assertEquals(expectedOutput.size(), actualOutput.size());
		}
	}
	//filterBySearchKey is a private method of SearchVenueDao class and has been tested along with the above test case.
}
