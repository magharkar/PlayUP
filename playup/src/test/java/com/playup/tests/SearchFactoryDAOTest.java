package com.playup.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchFactoryDAOTest {

	@Test
	public void searchFactoryDAOTestClass() throws ClassNotFoundException {
	    Class<?> classExists = Class.forName("com.playup.dao.SearchFactoryDAO", false, getClass().getClassLoader());
	    assertNotNull(classExists);
	}
}
