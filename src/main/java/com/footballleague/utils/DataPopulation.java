package com.footballleague.utils;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.footballleague.model.Countries;

@Component
public class DataPopulation{
	private Map<String, String> countries;

	public Map<String, String> getCountries() {
		return countries;
	}

	public void setCountries(Map<String, String> countries) {
		this.countries = countries;
	}
	
	
}