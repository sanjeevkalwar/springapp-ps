package com.footballleague.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballleague.model.Countries;
import com.footballleague.model.Country;

@Service
public class CountryService {
	
	@Autowired
	private FootballStandingApiServiceImpl footballStandingApiServiceImpl;
	
	public List<Country> getCountryFromApi() {
		return footballStandingApiServiceImpl.getCountries();
	}

}
