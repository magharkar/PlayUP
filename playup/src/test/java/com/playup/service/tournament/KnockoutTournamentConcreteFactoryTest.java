package com.playup.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import com.playup.database.PlayupDBConnection;
import com.playup.model.tournament.TournamentDataModel;
import com.playup.model.tournament.TournamentMatchModel;
import com.playup.model.tournament.TournamentPlayerModel;
import com.playup.model.tournament.TournamentTeamModel;
import com.playup.model.user.User;
import com.playup.service.tournament.KnockoutTournamentConcreteFactory;

class KnockoutTournamentConcreteFactoryTest {

	@Test
	void knockoutTournamentConcreteFactoryTest() throws ClassNotFoundException {
		Class<?> classExists = Class.forName("com.playup.service.tournament.KnockoutTournamentConcreteFactory", false,
				getClass().getClassLoader());
		assertNotNull(classExists);
	}

	@Test
	void createScheduleTest() throws SQLException {
		TournamentDataModel tournamentDataModel = new TournamentDataModel();
		tournamentDataModel.setTournamentName("TestTournament");
		tournamentDataModel.setTournamentSport("Badminton");
		tournamentDataModel.setTournamentType("Knockout Tournament");
		tournamentDataModel.setPlayersPerTeam("2");

		List<User> userList = new ArrayList<User>();

		for (int userIterator = 1; userIterator <= 10; userIterator++) {
			User testUser = new User();
			String email = "testuser" + userIterator + "@gmail.com";
			testUser.setUserId(userIterator);
			testUser.setEmail(email);
			testUser.setContactNumber("testContactNumber" + userIterator);
			testUser.setPassword("testPassword" + userIterator);
			testUser.setUserName("testUsername" + userIterator);
			testUser.setCity("testCity" + userIterator);
			testUser.setRole("customer" + userIterator);
			testUser.setSport("Badminton");
			userList.add(testUser);
		}

		PlayupDBConnection dbCon = Mockito.mock(PlayupDBConnection.class);
		MockedStatic<PlayupDBConnection> mocked = mockStatic(PlayupDBConnection.class);
		mocked.when(PlayupDBConnection::getInstance).thenReturn(dbCon);
		ResultSet resultSetMock = Mockito.mock(ResultSet.class);
		Mockito.when(dbCon.readData("Select * from User;")).thenReturn(resultSetMock);
		Mockito.when(dbCon.readData("Select Tournament_id from Tournament;")).thenReturn(resultSetMock);
		Mockito.when(dbCon.updateData(Mockito.anyString())).thenReturn(true);
		Mockito.when(resultSetMock.getString("user_id")).thenReturn("1").thenReturn("2").thenReturn("3").thenReturn("4")
				.thenReturn("5").thenReturn("6").thenReturn("7").thenReturn("8").thenReturn("9").thenReturn("10");
		Mockito.when(resultSetMock.getString("email")).thenReturn("testuser1@gmail.com")
				.thenReturn("testuser2@gmail.com").thenReturn("testuser3@gmail.com").thenReturn("testuser4@gmail.com")
				.thenReturn("testuser5@gmail.com").thenReturn("testuser6@gmail.com").thenReturn("testuser7@gmail.com")
				.thenReturn("testuser8@gmail.com").thenReturn("testuser9@gmail.com").thenReturn("testuser10@gmail.com");
		Mockito.when(resultSetMock.getString("phone")).thenReturn("testContactNumber1").thenReturn("testContactNumber2")
				.thenReturn("testContactNumber3").thenReturn("testContactNumber4").thenReturn("testContactNumber5")
				.thenReturn("testContactNumber6").thenReturn("testContactNumber7").thenReturn("testContactNumber8")
				.thenReturn("testContactNumber9").thenReturn("testContactNumber10");
		Mockito.when(resultSetMock.getString("password")).thenReturn("testPassword1").thenReturn("testPassword2")
				.thenReturn("testPassword3").thenReturn("testPassword4").thenReturn("testPassword5")
				.thenReturn("testPassword6").thenReturn("testPassword7").thenReturn("testPassword8")
				.thenReturn("testPassword9").thenReturn("testPassword10");
		Mockito.when(resultSetMock.getString("city")).thenReturn("testCity1").thenReturn("testCity2")
				.thenReturn("testCity3").thenReturn("testCity4").thenReturn("testCity5").thenReturn("testCity6")
				.thenReturn("testCity7").thenReturn("testCity8").thenReturn("testCity9").thenReturn("testCity10");
		Mockito.when(resultSetMock.getString("username")).thenReturn("testUsername1").thenReturn("testUsername2")
				.thenReturn("testUsername3").thenReturn("testUsername4").thenReturn("testUsername5")
				.thenReturn("testUsername6").thenReturn("testUsername7").thenReturn("testUsername8")
				.thenReturn("testUsername9").thenReturn("testUsername10");
		Mockito.when(resultSetMock.getString("role")).thenReturn("customer1").thenReturn("customer2")
				.thenReturn("customer3").thenReturn("customer4").thenReturn("customer5").thenReturn("customer6")
				.thenReturn("customer7").thenReturn("customer8").thenReturn("customer9").thenReturn("customer10");
		Mockito.when(resultSetMock.getString("sport")).thenReturn("Badminton");
		Mockito.when(resultSetMock.getString("Tournament_id")).thenReturn("1").thenReturn("2").thenReturn("3")
				.thenReturn("4").thenReturn("5").thenReturn("6").thenReturn("7").thenReturn("8").thenReturn("9")
				.thenReturn("10");
		Mockito.when(resultSetMock.next()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true)
				.thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true)
				.thenReturn(false).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true)
				.thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);

		KnockoutTournamentConcreteFactory knockoutTournament = new KnockoutTournamentConcreteFactory();
		knockoutTournament.createSchedule(tournamentDataModel);
		
	}
}