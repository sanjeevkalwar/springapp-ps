package com.footballleague.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.footballleague.model.StandingInfo;
import com.footballleague.service.FootballStandingService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class FootballStandingsController {

	@Autowired
	private FootballStandingService footballStandingService;

	@GetMapping("/standings")
	public List<StandingInfo> getStandingsBasedOnCountryAndLeagueAndTeamNameInQuery(
			@RequestParam(value = "country", required = true) String countryName,
			@RequestParam(value = "league", required = true) String leagueName,
			@RequestParam(value = "team", required = true) String teamName) {

		List<StandingInfo> info = footballStandingService.getStandingInfoForATeamInALeague(countryName, leagueName,
				teamName, false);

		return info;

	}

}
