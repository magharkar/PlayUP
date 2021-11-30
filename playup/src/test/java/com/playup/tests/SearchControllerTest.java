package com.playup.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import com.playup.controller.SearchController;
import com.playup.model.Venue;
import com.playup.database.DataBaseUtilities;

class SearchControllerTest {

	//Not null class test
	@Test
	void searchControllerNotNullTest() throws ClassNotFoundException {
		Class<?> classFinder = Class.forName("com.playup.controller.SearchController", false, getClass().getClassLoader());
		assertNotNull(classFinder);
	}
	
	@Test
	void searchModelAndViewTest() {
		assertEquals("search", new SearchController().search().getViewName());
	}
	
	@Test
	void getSearchResultsTest() throws SQLException {
		ArrayList<Object> expectedOutput = new ArrayList<Object>();
		SearchController sc = new SearchController();
		List<Venue> venueList = new ArrayList<Venue>();
		Venue venue1 = new Venue("2000001", "DalPlex", "Halifax", "5", "10", "8:00:00", "20:00", "902-494-3372",
				"44.6345Ą N", "63.5926Ą W", "$50", "4", "0");
		Venue venue2 = new Venue("2000002", "Truro stadium", "Truro", "4", "10", "8:00:00", "20:00", "902-494-3372",
				"44.6345Ą N", "63.5926Ą W", "$50", "4", "0");
		Venue venue3 = new Venue("2000003", "Bayer's stadium", "Toronto", "5", "10", "8:00:00", "20:00", "902-494-3372",
				"44.6345Ą N", "63.5926Ą W", "$50", "4", "0");
		venueList.add(venue1);
		venueList.add(venue2);
		venueList.add(venue3);
		DataBaseUtilities dbUtils = Mockito.mock(DataBaseUtilities.class);
		try (MockedStatic<DataBaseUtilities> mocked = mockStatic(DataBaseUtilities.class)) {
			mocked.when(DataBaseUtilities::getInstance).thenReturn(dbUtils);
			Mockito.when(dbUtils.getVenuesFromDB()).thenReturn(venueList);
			ArrayList<Object> actualOutput = sc.getSearchResults("Hali");
			expectedOutput.add(venue1);
			assertEquals(expectedOutput.size(), actualOutput.size());
		}

	}
}
