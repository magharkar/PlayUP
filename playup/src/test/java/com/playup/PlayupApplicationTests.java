package com.playup;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.playup.controller.PlayupDBConnection;

@SpringBootTest
class PlayupApplicationTests {
	
	@Test
	public void PlayupDBConnectionTest() {
		List<String> actualOutput = PlayupDBConnection.dbConnect();
		assertNotEquals(Collections.EMPTY_LIST, actualOutput);
	}
}
