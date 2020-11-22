package com.footballleague.model;

import java.util.ArrayList;
import java.util.List;

public class Standings {

	private List<Standing> standings;
	Standings(){
		standings=new ArrayList<>();
	}
	public List<Standing> getStandings() {
		return standings;
	}
	
	
}
