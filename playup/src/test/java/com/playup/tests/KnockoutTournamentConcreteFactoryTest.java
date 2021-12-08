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
			testUser.setCity("testCity" + userIterator);
			userList.add(testUser);
		}
		PlayupDBConnection dbCon = Mockito.mock(PlayupDBConnection.class);
		try (MockedStatic<PlayupDBConnection> mocked = mockStatic(PlayupDBConnection.class)) {
			mocked.when(PlayupDBConnection::getInstance).thenReturn(dbCon);
			ResultSet resultSetMock = Mockito.mock(ResultSet.class);
			Mockito.when(dbCon.readData("Select * from User;")).thenReturn(resultSetMock);
			for (int mockIterator = 1; mockIterator <= 10; mockIterator++) {
				Mockito.when(resultSetMock.getString("user_id")).thenReturn("");
				Mockito.when(resultSetMock.getString("email")).thenReturn("");
				Mockito.when(resultSetMock.getString("phone")).thenReturn("");
				Mockito.when(resultSetMock.getString("password")).thenReturn("");
				Mockito.when(resultSetMock.getString("city")).thenReturn("");
				Mockito.when(resultSetMock.getString("username")).thenReturn("");
				Mockito.when(resultSetMock.getString("role")).thenReturn("");
				Mockito.when(resultSetMock.getString("sport")).thenReturn("");
			}
		}
		List<TournamentPlayerModel> playerModelList = new ArrayList<TournamentPlayerModel>();
		List<TournamentTeamModel> teamModelList = new ArrayList<TournamentTeamModel>();
		List<TournamentMatchModel> matchModelList = new ArrayList<TournamentMatchModel>();

		TournamentPlayerModel tournamentPlayerModel1 = new TournamentPlayerModel("Test Player 1",
				"testplayerusername1");
		TournamentPlayerModel tournamentPlayerModel2 = new TournamentPlayerModel("Test Player 2",
				"testplayerusername2");
		TournamentTeamModel tournamentTeamModel1 = new TournamentTeamModel(playerModelList, "testTeamNumber001");
		TournamentTeamModel tournamentTeamModel2 = new TournamentTeamModel(playerModelList, "testTeamNumber002");
		TournamentTeamModel tournamentTeamModel3 = new TournamentTeamModel(playerModelList, "testTeamNumber001");
		playerModelList.add(tournamentPlayerModel1);
		playerModelList.add(tournamentPlayerModel2);
		try (MockedStatic<PlayupDBConnection> mocked = mockStatic(PlayupDBConnection.class)) {
			mocked.when(PlayupDBConnection::getInstance).thenReturn(dbCon);
			ResultSet resultSetMock = Mockito.mock(ResultSet.class);
			Mockito.when(dbCon.readData("Select Tournament_id from Tournament;")).thenReturn(resultSetMock);
			Mockito.when(resultSetMock.getString("Tournament_id")).thenReturn("100");

		}
	}
}