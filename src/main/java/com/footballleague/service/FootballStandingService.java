package com.footballleague.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.footballleague.exception.CountryNotFoundException;
import com.footballleague.exception.LeagueNotFoundException;
import com.footballleague.exception.TeamNotFoundException;
import com.footballleague.model.Country;
import com.footballleague.model.League;
import com.footballleague.model.Standing;
import com.footballleague.model.StandingInfo;
import com.footballleague.model.Team;
import com.footballleague.utils.DataPopulation;
import com.google.common.annotations.VisibleForTesting;

@Service
public class FootballStandingService {

	private static final String LEAGUE_NOT_FOUND = "League Not Found";

	private static final String COUNTRY_NOT_FOUND = "Country Not Found";

	private static final String NO_STANDING_FOUND_FOR_TEAM = "No Standing found for team";

	@Autowired
	private FootballStandingApiServiceImpl footballStandingApiServiceImpl;

	@Autowired
	private CountryService countryService;
	
	@Autowired
	private DataPopulation dataPopulation;

	@Autowired
	private LeagueService leagueService;

	@Async
	public CompletableFuture<List<StandingInfo>> getStandingInfoForATeamInALeague2(String countryName, String leagueName, String teamName,
			boolean isSorted) {
		return CompletableFuture.supplyAsync(()->{
			if(!dataPopulation.getCountries().containsKey(countryName)) {
				System.out.println("countryName:===="+ countryName + "===" + dataPopulation.getCountries().toString());
				throw new CountryNotFoundException(COUNTRY_NOT_FOUND);
			}
			Map<String,String> leagueMap= getLeagues(countryName, dataPopulation.getCountries());
			if(leagueMap==null || leagueMap.size()==0 || !leagueMap.containsKey(leagueName))
				throw new LeagueNotFoundException(LEAGUE_NOT_FOUND);
			return leagueMap;
		}).thenApply((leagueMap)->{
			return isSorted ? getListOfStandings(leagueMap.get(leagueName), dataPopulation.getCountries(),teamName).stream()
					.collect(Collectors.toMap(StandingInfo::getStanding, standing -> standing)).entrySet().stream()
					.sorted(Comparator.comparing(Map.Entry::getKey)).map(Map.Entry::getValue).collect(Collectors.toList())
					: getListOfStandings(leagueMap.get(leagueName), dataPopulation.getCountries(),teamName);

		});
		
	}
	public List<StandingInfo> getStandingInfoForATeamInALeague(String countryName, String leagueName, String teamName,
			boolean isSorted) {
		Map<String, String> leagueMap;
		if(dataPopulation.getCountries().containsKey(countryName)) {
			leagueMap= getLeagues(countryName, dataPopulation.getCountries());
			System.out.println("$$$$$$"+"inside first if");
		}
		else {
			System.out.println("$$$$$$"+"inside else");
			throw new CountryNotFoundException(COUNTRY_NOT_FOUND);
			
		}
		
		if(leagueMap==null || leagueMap.size()==0 || !leagueMap.containsKey(leagueName))
			throw new LeagueNotFoundException(LEAGUE_NOT_FOUND);
		return isSorted ? getListOfStandings(leagueMap.get(leagueName), dataPopulation.getCountries(),teamName).stream()
				.collect(Collectors.toMap(StandingInfo::getStanding, standing -> standing)).entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry::getKey)).map(Map.Entry::getValue).collect(Collectors.toList())
				: getListOfStandings(leagueMap.get(leagueName), dataPopulation.getCountries(),teamName);

	}

	@VisibleForTesting
	List<StandingInfo> getListOfStandings(String leagueID, Map<String, String> countryMap,
			String teamName) {
		List<Standing> standings=footballStandingApiServiceImpl.getStandingsInfoByLeagueId(leagueID);
		if(standings==null || standings.size()==0) {
			throw new TeamNotFoundException(NO_STANDING_FOUND_FOR_TEAM);
		}
		else {
			List<StandingInfo> standingInfo=standings
			.stream()
			.filter(standing->standing.getTeam_name().equalsIgnoreCase(teamName))
			.map(standing -> {
				Country country = new Country();
				country.setCountryId(countryMap.get(standing.getCountry_name()));
				country.setCountryName(standing.getCountry_name());
				Team team = new Team();
				team.setTeam_key(standing.getTeam_id());
				team.setTeam_name(standing.getTeam_name());
				League league = new League();
				league.setLeagueId(standing.getLeague_id());
				league.setLeagueName(standing.getLeague_name());
				return new StandingInfo(country,team,Integer.parseInt(standing.getOverall_league_position()),league);
			}).collect(Collectors.toList());
		if(standingInfo==null || standingInfo.size()==0)
			throw new TeamNotFoundException(NO_STANDING_FOUND_FOR_TEAM);
		else
			return standingInfo;
		}
	}

	private Map<String, String> getLeagues(String countryName, Map<String, String> countryMap) {
		Map<String, String> leagueMap = leagueService
				.getLeaguesForACountryFromApi(countryMap.get(countryName))
				.stream().collect(Collectors.toMap(League::getLeagueName, League::getLeagueId));
		return leagueMap;
	}
}
