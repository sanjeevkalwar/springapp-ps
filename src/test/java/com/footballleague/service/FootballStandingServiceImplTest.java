package com.footballleague.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.footballleague.exception.TeamNotFoundException;
import com.footballleague.model.League;
import com.footballleague.model.Standing;
import com.footballleague.model.StandingInfo;
import com.footballleague.utils.DataPopulation;

@RunWith(MockitoJUnitRunner.class)
public class FootballStandingServiceImplTest {

	@InjectMocks
	private FootballStandingService footballStandingService;

	@Mock
	private FootballStandingApiServiceImpl footballStandingApiServiceImpl;

	@Mock
	private DataPopulation dataPopulation;

	@Mock
	private LeagueService leagueService;
	Map<String, String> countryMap = Map.of("England", "41");
	List<League> leagueList = new ArrayList<League>();
	List<Standing> standingInfo = new ArrayList<Standing>();

	@Before
	public void setUp() {
		League league = new League();
		league.setCountryId("41");
		league.setCountryName("England");
		league.setLeagueId("149");
		league.setLeagueName("Championship");
		leagueList.add(league);
		when(dataPopulation.getCountries()).thenReturn(countryMap);
		when(leagueService.getLeaguesForACountryFromApi(anyString())).thenReturn(leagueList);
		when(footballStandingApiServiceImpl.getStandingsInfoByLeagueId(anyString())).thenReturn(standingInfo);
	}

	@Test(expected = TeamNotFoundException.class)
	public void getDataForStandings() {
		List<StandingInfo> info = footballStandingService.getStandingInfoForATeamInALeague("England", "Championship",
				"Birmingham", false);
		assertNotNull(info);
	}

}
