package com.footballleague.model;

import java.util.Map;

public class Leagues {

	private Map<String, League> leagues;

	public Map<String, League> getLeagues() {
		return leagues;
	}

	public void setLeagues(Map<String, League> leagues) {
		this.leagues = leagues;
	}

	public Leagues(Map<String, League> leagues) {
		super();
		this.leagues = leagues;
	}

}
