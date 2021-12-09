/**
 * @author vibhorbhatnagar
 */

package com.playup.service.tournament;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.playup.constants.QueryConstants;
import com.playup.database.PlayupDBConnection;
import com.playup.model.tournament.TournamentMatchModel;
import com.playup.model.tournament.TournamentPlayerModel;
import com.playup.model.tournament.TournamentScheduleModel;
import com.playup.model.tournament.TournamentTeamModel;
import com.playup.model.tournament.TournamentDataModel;
import com.playup.model.user.User;

public class KnockoutTournamentConcreteFactory implements ITournamentFactory {

	@Override
	public TournamentScheduleModel createSchedule(TournamentDataModel tournamentDataModel) {
		tournamentDataModel.setTournamentId(generateTournamentID());
		List<User> userList = getEligibleUsers(tournamentDataModel.getTournamentSport());
		List<TournamentPlayerModel> playerModelList = getPlayers(userList);
		List<TournamentTeamModel> teamModelList = getTeams(playerModelList,
				Integer.valueOf(tournamentDataModel.getPlayersPerTeam()));
		List<TournamentMatchModel> matchModelList = getMatches(teamModelList);
		updateMatchesTableInDB(matchModelList, tournamentDataModel.getTournamentId());
		return new TournamentScheduleModel(tournamentDataModel.getTournamentId(), matchModelList);
	}

	private String generateTournamentID() {
		List<String> tournamentIDsList = getTournamentIDsFromDB();
		if (tournamentIDsList.isEmpty()) {
			return "1";
		}
		try {
			Double max = 0d;
			for (String tournamenetID : tournamentIDsList) {
				if (Double.valueOf(tournamenetID) > max) {
					max = Double.valueOf(tournamenetID);
				}
			}
			max++;
			return String.valueOf(max.intValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<TournamentMatchModel> getMatches(List<TournamentTeamModel> teamModelList) {
		List<TournamentMatchModel> matchModelList = new ArrayList<TournamentMatchModel>();
		Date dateOfMatch = getStartDate();
		int length = teamModelList.size() % 2 == 0 ? teamModelList.size() : teamModelList.size() - 1;
		for (int i = 0; i < length;) {
			if (i + 1 % 5 == 0) {
				dateOfMatch = addOneDay(dateOfMatch);
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
			matchModelList.add(new TournamentMatchModel(teamModelList.get(i), teamModelList.get(i + 1),
					sdf.format(dateOfMatch), null));
			i = i + 2;
		}
		if (teamModelList.size() % 2 != 0) {
			matchModelList.add(new TournamentMatchModel(teamModelList.get(teamModelList.size() - 1), null,
					matchModelList.get(matchModelList.size() - 1).getMatchDate(),
					teamModelList.get(teamModelList.size() - 1)));
		}
		return matchModelList;
	}

	private Date addOneDay(Date dateOfMatch) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateOfMatch);
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
		return cal.getTime();
	}

	private Date getStartDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 10);
		return cal.getTime();
	}

	private List<TournamentTeamModel> getTeams(List<TournamentPlayerModel> playerModelList, Integer playersPerTeam) {
		List<TournamentTeamModel> teamModelList = new ArrayList<TournamentTeamModel>();
		int teamNumber = 1;
		int i = 0;
		while (i + playersPerTeam <= playerModelList.size()) {
			teamModelList.add(new TournamentTeamModel(playerModelList.subList(i, i + playersPerTeam),
					String.valueOf(teamNumber)));
			teamNumber++;
			i = i + playersPerTeam;
		}
		return teamModelList;
	}

	private List<TournamentPlayerModel> getPlayers(List<User> userList) {
		List<TournamentPlayerModel> playerModelList = new ArrayList<TournamentPlayerModel>();
		for (User user : userList) {
			playerModelList.add(new TournamentPlayerModel(String.valueOf(user.getUserId()), user.getUserName()));
		}
		return playerModelList;
	}

	private List<User> getEligibleUsers(String tournamentSport) {
		List<User> userList = getUsersFromDB();
		Iterator<User> iterator = userList.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (!user.getSport().equalsIgnoreCase(tournamentSport)) {
				iterator.remove();
			}
		}
		return userList;
	}

	private static List<User> getUsersFromDB() {
		List<User> userList = new ArrayList<>();
		ResultSet resultSet = PlayupDBConnection.getInstance().readData("Select * from User;");
		try {
			while (resultSet != null && resultSet.next()) {
				User user = new User();
				user.setUserId(resultSet.getInt("user_id"));
				user.setEmail(resultSet.getString("email"));
				user.setContactNumber(resultSet.getString("phone"));
				user.setPassword(resultSet.getString("password"));
				user.setUserName(resultSet.getString("username"));
				user.setCity(resultSet.getString("city"));
				user.setRole(resultSet.getString("role"));
				user.setSport(resultSet.getString("sport"));
				userList.add((User) user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	private static List<String> getTournamentIDsFromDB() {
		List<String> tournamentIDsList = new ArrayList<>();
		ResultSet resultSet = PlayupDBConnection.getInstance().readData("Select Tournament_id from Tournament;");
		try {
			while (resultSet != null && resultSet.next()) {
				tournamentIDsList.add(resultSet.getString("Tournament_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tournamentIDsList;
	}

	private static boolean updateMatchesTableInDB(List<TournamentMatchModel> matchModel, String tournamentID) {
		try {
			return PlayupDBConnection.getInstance().updateData(QueryConstants.INSERT_INTO_MATCHES_TABLE + tournamentID
					+ "', '" + convertToString(matchModel) + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private static String convertToString(List<TournamentMatchModel> matchModelList) {
		StringBuffer sb = new StringBuffer();
		for (TournamentMatchModel matchModel : matchModelList) {
			if (matchModel == null) {
				continue;
			}
			if (matchModel.getTeamOne() == null) {
				if (matchModel.getTeamTwo() == null) {
					continue;
				}
				sb.append("null").append(", ").append(matchModel.getTeamTwo().getTeamNumber()).append(", ")
						.append(matchModel.getMatchDate()).append(", ")
						.append(matchModel.getWinningTeam().getTeamNumber()).append(" || ");
			} else if (matchModel.getTeamTwo() == null) {
				sb.append(matchModel.getTeamOne().getTeamNumber()).append(", ").append("null").append(", ")
						.append(matchModel.getMatchDate()).append(", ").append(matchModel.getWinningTeam())
						.append(" || ");
			} else {
				sb.append(matchModel.getTeamOne().getTeamNumber()).append(", ")
						.append(matchModel.getTeamTwo().getTeamNumber()).append(", ").append(matchModel.getMatchDate())
						.append(", ").append(matchModel.getWinningTeam()).append(" || ");
			}
		}
		return sb.toString().substring(0, sb.toString().length() - 3);
	}
}
