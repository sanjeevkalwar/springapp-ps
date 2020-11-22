package com.footballleague.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.footballleague.model.Countries;
import com.footballleague.model.Country;
import com.footballleague.model.League;
import com.footballleague.model.Leagues;
import com.footballleague.model.Standing;
import com.footballleague.model.Standings;
import com.footballleague.model.Teams;
import com.footballleague.utils.Constants;

@Service
public class FootballStandingApiServiceImpl implements FootballStandingApiService {

	@Autowired
	private RestTemplate restTemplate;
	@Override
	public List<Country> getCountries() {
		ResponseEntity<Country[]> val= 
				restTemplate.getForEntity(Constants.GET_COUNTRIES_API_URL, Country[].class);
		return  Arrays.asList(val.getBody());
	}

	@Override
	public List<League> getLeaguesByCountryId(String countryId) {
		ResponseEntity<League[]> val= 
				restTemplate.getForEntity(String.format(Constants.GET_LEAGUES_BY_COUNTRY_API_URL, countryId), League[].class);
		return  Arrays.asList(val.getBody());
		}

	@Override
	public List<Standing> getStandingsInfoByLeagueId(String leagueId) {
		ResponseEntity<Standing[]> val= 
				restTemplate.getForEntity(String.format(Constants.GET_STANDINGS_BY_LEAGUE_API_URL, leagueId), Standing[].class);
		return  Arrays.asList(val.getBody());
	}
	
}
