package com.playup.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ISearchFactoryDaoTest {

	@Test
	public void searchFactoryDAOTestClass() throws ClassNotFoundException {
	    Class<?> classExists = Class.forName("com.playup.dao.ISearchFactoryDao", false, getClass().getClassLoader());
	    assertNotNull(classExists);
	}
}
