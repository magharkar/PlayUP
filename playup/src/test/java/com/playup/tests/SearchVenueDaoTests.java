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
}
