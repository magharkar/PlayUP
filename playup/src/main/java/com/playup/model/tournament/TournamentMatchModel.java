/**
 * @author vibhorbhatnagar
 */

package com.playup.model.tournament;

public class TournamentMatchModel {

	TournamentTeamModel teamOne;
	TournamentTeamModel teamTwo;
	String matchDate;
	TournamentTeamModel winningTeam;

	public TournamentMatchModel(TournamentTeamModel teamOne, TournamentTeamModel teamTwo, String dateOfMatch,
								TournamentTeamModel winningTeam) {
		this.teamOne = teamOne;
		this.teamTwo = teamTwo;
		this.matchDate = dateOfMatch;
		this.winningTeam = winningTeam;
	}

	public TournamentTeamModel getTeamOne() {
		return teamOne;
	}

	public void setTeamOne(TournamentTeamModel teamOne) {
		this.teamOne = teamOne;
	}

	public TournamentTeamModel getTeamTwo() {
		return teamTwo;
	}

	public void setTeamTwo(TournamentTeamModel teamTwo) {
		this.teamTwo = teamTwo;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public TournamentTeamModel getWinningTeam() {
		return winningTeam;
	}

	public void setWinningTeam(TournamentTeamModel winningTeam) {
		this.winningTeam = winningTeam;
	}

}
