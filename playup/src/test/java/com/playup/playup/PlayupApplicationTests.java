package com.playup.playup;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.playup.playup.controller.PlayupController;
import com.playup.playup.controller.PlayupDBConnection;

@SpringBootTest
class PlayupApplicationTests {
	
	@Test
	public void controllerTest() {
		PlayupController testController = new PlayupController();
		assertTrue(testController.BaseCode().equals("Hello World"));
	}
	
	@Test
	public void PlayupDBConnectionTest() {
		PlayupDBConnection connectTest = new PlayupDBConnection();
		String actualOutput = connectTest.dbConnect();
		assertEquals(actualOutput, "Vibhor");
	}
}
