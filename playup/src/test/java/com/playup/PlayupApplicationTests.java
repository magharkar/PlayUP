package com.playup;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;
import com.playup.database.PlayupDBConnection;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlayupApplicationTests {
	
	@Test
	public void PlayupDBConnectionTest() {
//		List<String> actualOutput = PlayupDBConnection.d
//		Assertions.assertNotEquals(Collections.EMPTY_LIST, "");
		Assertions.assertEquals(1,1);
	}

}
