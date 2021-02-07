package com.footballleague.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.footballleague.model.Country;
import com.footballleague.model.League;
import com.footballleague.service.FootballLeagueService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1")
public class CountryController {

	@Autowired
	private FootballLeagueService fbService;

	@GetMapping("/countries")
	public List<Country> getCountries() {
		return fbService.getAllCountries(); 
	}

	@ApiOperation(value = "Get all competitions where country is participating", response = List.class)
	@GetMapping(value = "/countries/{countryId}")
	public List<League> getCompetitionsForCountry(@PathVariable("countryId") String id) {
		List<League> competitions = fbService.getCompetitionsForCountry(id);

		return competitions;
	}
}
