package com.playup.service.search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AbstractSearchFactoryTest {

	@Test
	public void searchFactoryTestClass() throws ClassNotFoundException {
	    Class<?> classExists = Class.forName("com.playup.model.search.AbstractSearchFactory", false, getClass().getClassLoader());
	    assertNotNull(classExists);
	}
}
