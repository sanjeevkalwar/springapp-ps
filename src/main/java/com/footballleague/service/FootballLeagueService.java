package com.footballleague.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.footballleague.feign.FootballApiClient;
import com.footballleague.model.Countries;

@Component
public class FootballLeagueService {

	private final String apiKey;
	private final FootballApiClient footballApiClient;

	@Autowired
	public FootballLeagueService(@Value("${footballapi.apiKey}") String apiKey, FootballApiClient footballApiClient) {
		this.apiKey = apiKey;
		this.footballApiClient = footballApiClient;
	}
	
	public List<Map<String, String>> getAllStandingsInACompetition(String competitionId) {
		return footballApiClient.getAllStandingsInACompetition(apiKey, competitionId);
	}

	public List<Map<String, String>> getAllCompetitions() {
		return footballApiClient.getAllCompetitions(apiKey);
	}

	public List<Map<String, String>> getCompetitionsForCountry(String id) {
		return footballApiClient.getCompetitionsForCountry(apiKey, id);
	}

	public List<Map<String, Object>> getAllTeamsInACompetition(String competitionId) {
		return footballApiClient.getAllTeamsInACompetition(apiKey, competitionId);
	}

	public Countries getAllCountries() {
		return footballApiClient.getAllCountries(apiKey);
	}

	public List<Map<String, String>> getPlayerDetails(String playerId) {
		return footballApiClient.getPlayerDetails(apiKey, playerId);
	}

	public List<Map<String, Object>> getTeam(String teamId) {
		return footballApiClient.getTeam(apiKey, teamId);
	}
}