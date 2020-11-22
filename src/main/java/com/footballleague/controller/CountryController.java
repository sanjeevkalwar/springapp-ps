package com.footballleague.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.footballleague.model.Countries;
import com.footballleague.model.Country;
import com.footballleague.service.CountryService;

import com.footballleague.service.FootballLeagueService;



@RestController
@RequestMapping("api/v1")
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@Autowired
	private FootballLeagueService footballLeagueService;

	@GetMapping("/countries")
	public List<Country> getCOuntries() {
		return countryService.getCountryFromApi();
	}
	
	
	@GetMapping(value = "/countriesnew")
	public ResponseEntity<List<Country>> getCountries() {
		Countries countries = footballLeagueService.getAllCountries();
		return ResponseEntity.ok(countries.getCountries());
	}
}
