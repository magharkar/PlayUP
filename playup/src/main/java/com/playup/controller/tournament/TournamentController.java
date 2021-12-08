/**
 * @author vibhorbhatnagar
 */

package com.playup.controller.tournament;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.playup.model.tournament.TournamentScheduleModel;
import com.playup.service.tournament.KnockoutTournamentConcreteFactory;
import com.playup.model.tournament.TournamentDataModel;

@RestController
public class TournamentController {

	@RequestMapping("/tournamentScheduler")
	public ModelAndView tournamentScheduling() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tournament_scheduler");
		return mv;
	}

	@RequestMapping(value = "/tournamentScheduler/getMatchSchedule", method = RequestMethod.POST)
	public @ResponseBody List<Object> tournamentScheduler(@RequestBody TournamentDataModel tournamentData) {
		List<Object> objectList = new ArrayList<>();
		tournamentData.validate();
		if (tournamentData.getError() != null) {
			objectList.add(null);
			objectList.add(tournamentData.getError());
			return objectList;
		}
		objectList.add(new KnockoutTournamentConcreteFactory().createSchedule(tournamentData));
		objectList.add(null);
		return objectList;
	}
}