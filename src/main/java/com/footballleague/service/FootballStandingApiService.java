package com.footballleague.service;

import java.util.List;

import com.footballleague.model.Countries;
import com.footballleague.model.Country;
import com.footballleague.model.League;
import com.footballleague.model.Leagues;
import com.footballleague.model.Standing;
import com.footballleague.model.Standings;
import com.footballleague.model.Team;
import com.footballleague.model.Teams;

public interface FootballStandingApiService {
	
	List<Country> getCountries();
	List<League> getLeaguesByCountryId(String countryId);
	List<Standing> getStandingsInfoByLeagueId(String leagueId);
}
