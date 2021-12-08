/**
 * @author vibhorbhatnagar
 */

package com.playup.model.tournament;

import java.util.List;

public class TournamentTeamModel {
	
	List<TournamentPlayerModel> players;
	String teamNumber;
	
	public TournamentTeamModel(List<TournamentPlayerModel> players, String teamNumber) {
		super();
		this.players = players;
		this.teamNumber = teamNumber;
	}

	public List<TournamentPlayerModel> getPlayers() {
		return players;
	}

	public void setPlayers(List<TournamentPlayerModel> players) {
		this.players = players;
	}

	public String getTeamNumber() {
		return teamNumber;
	}

	public void setTeamNumber(String teamNumber) {
		this.teamNumber = teamNumber;
	}
	
}
