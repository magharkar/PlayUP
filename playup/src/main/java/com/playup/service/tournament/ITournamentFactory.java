package com.playup.service.tournament;

import com.playup.model.tournament.TournamentDataModel;
import com.playup.model.tournament.TournamentScheduleModel;

/**
 * @author vibhorbhatnagar
 */

public interface ITournamentFactory {
	TournamentScheduleModel createSchedule(TournamentDataModel tournamentDataModel);
}
