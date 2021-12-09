package com.playup.model.tournament;

/**
 * @author vibhorbhatnagar
 */

public class TournamentDataModel {
	String tournamentId;
	String tournamentType;
	String tournamentSport;
	String playersPerTeam;
	String error;

	public String getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}

	public String getTournamentType() {
		return tournamentType;
	}

	public void setTournamentType(String tournamentType) {
		this.tournamentType = tournamentType;
	}

	public String getTournamentSport() {
		return tournamentSport;
	}

	public void setTournamentSport(String tournamentSport) {
		this.tournamentSport = tournamentSport;
	}

	public String getPlayersPerTeam() {
		return playersPerTeam;
	}

	public void setPlayersPerTeam(String playersPerTeam) {
		this.playersPerTeam = playersPerTeam;
	}

	public String getError() {
		return error;
	}

	public void validate() {
		StringBuffer stringBuffer = new StringBuffer();
		if (this.tournamentSport == null || this.tournamentSport.isEmpty()) {
			stringBuffer.append("Tournament sport must be selected<br>");
		}
		if (this.tournamentType == null || this.tournamentType.isEmpty()) {
			stringBuffer.append("Tournament type must be selected<br>");
		}
		if (this.playersPerTeam == null || this.playersPerTeam.isEmpty()) {
			stringBuffer.append("Number of players cannot be empty<br>");
		}
		if (notANumber(this.playersPerTeam)) {
			stringBuffer.append("Number of players should be a number<br>");
		}
		this.error = stringBuffer.toString().isEmpty() ? null : stringBuffer.toString();
	}

	private boolean notANumber(String playersPerTeam) {
		try {
			Double.valueOf(playersPerTeam);
			return false;
		} catch (Exception e) {
			return true;
		}
	}

}
