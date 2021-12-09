package com.playup.model.tournament;

/**
 * @author vibhorbhatnagar
 */

public class TournamentPlayerModel {
	String playerName;
	String userName;

	public TournamentPlayerModel(String playerName, String userName) {
		super();
		this.playerName = playerName;
		this.userName = userName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
