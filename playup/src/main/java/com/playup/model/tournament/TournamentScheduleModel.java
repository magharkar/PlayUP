/**
 * @author vibhorbhatnagar
 */

package com.playup.model.tournament;

import java.util.List;

public class TournamentScheduleModel {

	String tournamentId;
	List<TournamentMatchModel> matchesList;

	public TournamentScheduleModel(String tournamentId, List<TournamentMatchModel> matchesList) {
		super();
		this.tournamentId = tournamentId;
		this.matchesList = matchesList;
	}

	public String getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}

	public List<TournamentMatchModel> getMatchesList() {
		return matchesList;
	}

	public void setMatchesList(List<TournamentMatchModel> matchesList) {
		this.matchesList = matchesList;
	}
}
