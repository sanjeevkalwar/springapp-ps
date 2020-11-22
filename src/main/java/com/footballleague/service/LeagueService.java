package com.footballleague.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballleague.model.Countries;
import com.footballleague.model.League;
import com.footballleague.model.Leagues;

@Service
public class LeagueService {
	
	@Autowired
	private FootballStandingApiServiceImpl footballStandingApiServiceImpl;
	
	public List<League> getLeaguesForACountryFromApi(String countryId) {
		return footballStandingApiServiceImpl.getLeaguesByCountryId(countryId);
	}

}
