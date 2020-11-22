package com.footballleague.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.footballleague.model.League;
import com.footballleague.service.LeagueService;

@RestController
@RequestMapping("api/v1")
public class LeagueController {

	@Autowired
	private LeagueService leagueService;

	@GetMapping("/leagues/{countryId}")
	public List<League> getLeaguesForACountryId(@PathVariable("countryId") String countryId) {
		return leagueService.getLeaguesForACountryFromApi(countryId);
	}
}
