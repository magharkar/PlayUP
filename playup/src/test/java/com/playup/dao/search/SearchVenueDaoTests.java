package com.playup.dao.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SearchVenueDaoTests {

	@Test
	void searchVenueNotNullTest() throws ClassNotFoundException {
		Class<?> classFinder = Class.forName("com.playup.dao.search.SearchVenueDao", false, getClass().getClassLoader());
		assertNotNull(classFinder);
	}
}

