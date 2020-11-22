package com.footballleague.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = CountryNotFoundException.class)
	public ResponseEntity<Object> handleWhenCountryNotFound(CountryNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = TeamNotFoundException.class)
	public ResponseEntity<Object> handleWhenTeamNotFound(TeamNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = LeagueNotFoundException.class)
	public ResponseEntity<Object> handleWhenLeagueNotFound(LeagueNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
