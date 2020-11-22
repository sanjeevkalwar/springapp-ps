package com.footballleague;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.footballleague.model.Country;
import com.footballleague.service.CountryService;
import com.footballleague.utils.DataPopulation;

@Configuration
public class FootballLeagueConfiguration implements CommandLineRunner {

	@Autowired
	private DataPopulation dataPopulation;

	@Autowired
	private CountryService countryService;

	@Override
	public void run(String... args) throws Exception {
		dataPopulation.setCountries(countryService.getCountryFromApi().stream()
				.collect(Collectors.toMap(Country::getCountry_name, Country::getCountry_id)));
		
	}

}
