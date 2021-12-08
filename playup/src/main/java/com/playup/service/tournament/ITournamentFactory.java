/**
 * @author vibhorbhatnagar
 */

package com.playup.service.tournament;

import com.playup.model.tournament.TournamentDataModel;
import com.playup.model.tournament.TournamentScheduleModel;

public interface ITournamentFactory {
	public TournamentScheduleModel createSchedule(TournamentDataModel tournamentDataModel);
}
